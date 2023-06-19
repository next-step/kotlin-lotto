package lotto

import lotto.view.InputView
import lotto.view.ResultView

class Lotto {
    fun buy(inputAmount: Int): Int {
        return inputAmount / 1000
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val lotto = Lotto()
            val inputView = InputView()
            val resultView = ResultView()

            val inputAmount = inputView.inputPurchaseAmount()
            val numOfLotto = lotto.buy(inputAmount)
            resultView.displayNumOfLotto(numOfLotto)
        }
    }
}