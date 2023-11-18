package lotto.domain

import lotto.view.MessageView
import lotto.view.enum.Message

class LottoAmount(private var amount: Int) {

    private final val messageView: MessageView = MessageView()

    fun getLottoCount(): Int = this.amount / LOTTO_PRICE

    fun processPayment(lottoCount: Int) {
        val paymentAmount: Int = (lottoCount * LOTTO_PRICE)
        val remainingAmount: Int = this.amount - paymentAmount

        require(remainingAmount >= 0) { this.messageView.getMessage(Message.LOTTO_PURCHASE_ERROR) }
        this.amount = remainingAmount
    }

    companion object {
        const val LOTTO_PRICE: Int = 1000
    }
}
