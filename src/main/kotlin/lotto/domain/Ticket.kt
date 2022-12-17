package lotto.domain

import lotto.common.Money

class Ticket(
    pricePolicy: PricePolicy
) {
    fun issue() {
        this.status = TicketStatus.ISSUE
    }

    val price: Money = pricePolicy.apply()
    var status: TicketStatus = TicketStatus.INIT
}