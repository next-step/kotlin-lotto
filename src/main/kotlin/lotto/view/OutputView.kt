package lotto.view

import lotto.controller.PurchaseResponse
import lotto.domain.LottoTicket

object OutputView {
    private const val PURCHASE_COUNT_MSG = "%d개를 구매했습니다"

    fun drawPurchaseOutput(response: PurchaseResponse) {
        drawPurchaseCount(response.tickets.size)
        drawTickets(response.tickets)
    }

    private fun drawPurchaseCount(count: Int) {
        println(PURCHASE_COUNT_MSG.format(count))
    }

    private fun drawTickets(tickets: List<LottoTicket>) {
       tickets.forEach { println(it.numbers) }
    }
}
