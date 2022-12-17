package lotto

import lotto.ui.PaymentInput

object LottoGame {
    private val paymentInput = PaymentInput()

    fun run() {
        paymentInput.draw()
    }
}
