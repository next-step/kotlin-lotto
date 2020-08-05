package lotto

import lotto.model.LottoManager
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    MoneyManager().execute()
}

class MoneyManager(
    private val input: InputView = InputView(),
    private val resultView: ResultView = ResultView
) {
    private lateinit var lottoManager: LottoManager

    fun execute() {
        val money = input.getBuyPrice()
        buyLotto(money)
        checkNumbers()
    }

    private fun buyLotto(money: Int) {
        lottoManager = LottoManager(money)
        resultView.showLottos(lottoManager.lottos)
    }

    private fun checkNumbers() {
        val (winnerNumber, bonusBall) = input.getNumbers()
        val winners = lottoManager.checkNumbers(winnerNumber, bonusBall)
        resultView.showWinners(winners)
    }
}
