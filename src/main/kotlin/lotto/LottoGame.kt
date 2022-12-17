package lotto

import lotto.ui.PaymentInput
import lotto.ui.PurchaseCount

object LottoGame {
    fun run() {
        val paymentInput = PaymentInput()
        paymentInput.draw()
        val payment = paymentInput.value
        val purchaseCount = PurchaseCount(payment = payment)
        purchaseCount.draw()
    }
}
