package study.lotto

import study.lotto.model.LottePrize
import study.lotto.view.InputView
import study.lotto.view.ResultView

/**
 * @author 이상준
 */
class LotteController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lotteService = LotteService()

    private val winLottoStatMap = mutableMapOf<LottePrize, Int>()

    init {
        LottePrize.entries.forEach {
            winLottoStatMap[it] = 0
        }

        run()
    }

    private fun run() {
        val money = inputView.inputMoney()
        val lottos = lotteService.buyLotto(money)
        resultView.printLotteCount(lottos)
        resultView.printLotte(lottos)
        val winLotto = inputView.inputWinLotte()

        lottos.forEach {
            val matchCount = lotteService.matchLotto(it, winLotto)

            if (matchCount > 2) {
                val prize = LottePrize.findPrize(matchCount) ?: throw IllegalArgumentException("당첨금이 없습니다.")
                winLottoStatMap[prize] = winLottoStatMap[prize]!!.plus(1)
            }
        }

        resultView.printWinLotte(winLottoStatMap)
        resultView.printProfit(lotteService.profitLotto(winLottoStatMap, money))
    }
}

fun main() {
    LotteController()
}
