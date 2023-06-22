package step2Lotto.controller

import step2Lotto.view.InputIO
import step2Lotto.view.InputMessage
import step2Lotto.view.InputView

class LottoController {
    private val inputIO = InputIO()
    private val inputView = InputView()

    fun inputPurchaseAmount(): Int {
        inputView.show(InputMessage.PURCHASE_AMOUNT)
        return inputIO.inputPurchaseAmount()
    }
}