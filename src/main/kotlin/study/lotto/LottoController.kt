package study.lotto

import study.lotto.model.LottoPrize
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

    fun run() {
        val money = inputView.inputMoney()
        val lottos = lottoService.buyLotto(money)
        resultView.printLottoCount(lottos)
        resultView.printLotto(lottos)
        val winLotto = inputView.inputWinLotto()

        lottos.forEach {
            val matchCount = it.matchLotto(winLotto)

            if (matchCount > 2) {
                val prize = LottoPrize.findPrize(matchCount) ?: throw IllegalArgumentException("당첨금이 없습니다.")
                winLottoStatsSet.find { lottoStat -> lottoStat.lottoPrize == prize }?.addCount() ?: run {
                    winLottoStatsSet.add(LottoStat(prize, 1))
                }
            }
        }

        resultView.printWinLotto(winLottoStatsSet)
        resultView.printProfit(lottoService.profitLotto(winLottoStatsSet, money))
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
