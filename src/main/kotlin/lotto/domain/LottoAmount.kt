package lotto.domain

import lotto.view.MessageView
import lotto.view.enum.Message

class LottoAmount(private var amount: Int) {

    // MessageView와 같이 메시지를 담는 view도 domain이 모르게 구현되어야 할까요?
    // 그렇다면, domain 에서는 어떻게 메시지를 처리해야 할까요?
    // domain 에서는 에러를 던지고 사용처에서 catch 해서 exception type에 따른 메시지를 출력하도록 하는 것이 좋을까요?
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
