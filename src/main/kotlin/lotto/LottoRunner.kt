package lotto

import lotto.adapter.`in`.ConsoleInputView
import lotto.adapter.`in`.LottoController
import lotto.adapter.out.ConsoleOutputView

class LottoRunner private constructor() {
    companion object {
        private val controller = LottoController()
        fun run() {
            purchaseLotto()
            checkLottoResult()
        }

        private fun purchaseLotto() {
            val purchaseAmount = ConsoleInputView().getPurchaseAmountInput()
            val response = controller.purchase(purchaseAmount)
            ConsoleOutputView().drawPurchaseOutput(response)
        }

        private fun checkLottoResult() {
            val winningNumbers = ConsoleInputView().getWinningNumbersInput()
            val response = controller.check(winningNumbers)
            ConsoleOutputView().drawLottoResult(response)
        }
    }

}

fun main() {
    LottoRunner.run()
}