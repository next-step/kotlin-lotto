package lotto.domain

import lotto.common.value.Money
import lotto.domain.enums.OrderStatus

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

    fun countTicket() = this.tickets.size()
}
