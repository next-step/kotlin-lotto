package study.lotto

import study.lotto.model.Lotto
import study.lotto.model.Rank
import study.lotto.model.LottoStat
import study.lotto.view.InputView
import study.lotto.view.ResultView

/**
 * @author 이상준
 */
class LottoController(
    private val lottoService: LottoService,
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    private val winLottoStatsSet = mutableSetOf<LottoStat>()

    init {
        Rank.entries.forEach {
            this.winLottoStatsSet.add(LottoStat(it))
        }
    }

    fun run() {
        val money = inputView.inputMoney()
        val lottos = lottoService.buyLotto(money)
        resultView.printLottoCount(lottos)
        resultView.printLotto(lottos)
        val winLotto = inputView.inputWinLotto()
        val bonus = inputView.inputBonusBall()

        playGame(lottos, winLotto, bonus)
        resultView.printWinLotto(this.winLottoStatsSet)
        resultView.printProfit(lottoService.profitLotto(this.winLottoStatsSet, money))
    }

    private fun playGame(
        lottos: List<Lotto>,
        winLotto: Lotto,
        bonus: Int,
    ) {
        lottos.forEach {
            val matchCount = it.matchLotto(winLotto)

            var matchBonus = false
            if (matchCount == Rank.THIRD.prize) {
                matchBonus = it.ishBonus(bonus)
            }
            val prize = Rank.findPrize(matchCount, matchBonus)
            this.winLottoStatsSet.find { lottoStat ->
                lottoStat.lottoPrize == prize
            }?.addCount()
        }
    }
}

fun main() {
    val lottoController = LottoController(
        LottoService(),
        InputView(),
        ResultView(),
    )

    lottoController.run()
}
