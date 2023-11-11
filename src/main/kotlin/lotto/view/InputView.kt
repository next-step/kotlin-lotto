package lotto.view

import lotto.util.validateInputNumber

object InputView {
    fun getBuyingMoney(): Int {
        OutputView.printRequestInputMoney()
        return readln().validateInputNumber().toInt()
    }
}
