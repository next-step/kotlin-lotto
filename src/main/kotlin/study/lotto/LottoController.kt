package study.lotto

import study.lotto.model.Lotto
import study.lotto.model.LottoNumber
import study.lotto.model.LottoStat
import study.lotto.model.LottoStats
import study.lotto.model.Lottos
import study.lotto.model.Rank
import study.lotto.view.InputView
import study.lotto.view.ResultView

/**
 * @author 이상준
 */
class LottoController(
    private val lottoOperator: LottoOperator,
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    private val lottoStats = LottoStats()
    private val lottos = Lottos()

    init {
        Rank.entries.forEach {
            this.lottoStats.addStat(LottoStat(it))
        }
    }

    fun run() {
        val money = inputSettingsFromMoney()
        val winLotto = inputView.inputWinLotto()
        val bonus = inputView.inputBonusBall(winLotto)

        playGame(lottos, winLotto, bonus)
        resultView.printWinLotto(this.lottoStats)
        resultView.printProfit(lottoOperator.profitLotto(this.lottoStats, money))
    }

    private fun inputSettingsFromMoney(): Int {
        val money = inputView.inputMoney()
        val manualCount = inputView.inputBuyManualCount(money)
        lottos.addAllLotto(inputView.inputManualLotto(manualCount))

        val autoCount = lottoOperator.boughtLottoCount(money) - manualCount
        lottos.addAllLotto(lottoOperator.buyLotto(autoCount))
        resultView.printLottoCount(manualCount, autoCount)
        resultView.printLotto(lottos)

        return money
    }

    private fun playGame(
        lottos: Lottos,
        winLotto: Lotto,
        bonus: LottoNumber,
    ) {
        lottos.getLottos().forEach {
            val matchCount = it.matchLotto(winLotto)

            var matchBonus = false
            if (matchCount == Rank.THIRD.countOfMatch) {
                matchBonus = it.ishBonus(bonus)
            }
            val rank = Rank.findRank(matchCount, matchBonus)
            this.lottoStats.getStat().find { lottoStat ->
                lottoStat.rank == rank
            }?.addCount()
        }
    }
}

fun main() {
    val lottoController =
        LottoController(
            LottoOperator(),
            InputView(),
            ResultView(),
        )

    lottoController.run()
}
