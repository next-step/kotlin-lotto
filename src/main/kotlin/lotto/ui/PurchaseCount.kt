package lotto.ui

import lotto.LottoTicket

class PurchaseCount(payment: Int) : UI {
    private val count: Int

    init { this.count = payment / LottoTicket.LOTTO_TICKET_PRICE }

    override fun draw() { println("${this.count}개를 구매했습니다.") }
}
