package lotto.domain

import lotto.common.value.Money
import lotto.domain.enums.OrderStatus
import lotto.domain.enums.TicketType

class Order(
    val paymentPrice: Money,
    val tickets: Tickets,
) {
    private var status: OrderStatus = OrderStatus.INIT

    init {
        require(tickets.totalPrice() == paymentPrice) { "지불금액과 종합가격은 동일해야 합니다." }
    }

    fun complete() {
        check(status == OrderStatus.INIT) { "주문을 완료할 수 있는 상태가 아닙니다" }
        tickets.issue()
        this.status = OrderStatus.COMPLETE
    }

    fun toLotteryNumbers() = tickets.toLotteryNumbers()

    fun countTotalTicket() = this.tickets.size()
    fun countTicket(ticketType: TicketType) = this.tickets.size(ticketType)
}
