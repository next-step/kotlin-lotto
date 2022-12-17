package lotto.domain

import lotto.common.Money
import lotto.common.Quantity
import lotto.domain.enums.TicketType
import lotto.domain.policy.PricePolicy

class Tickets(
    private val tickets: List<Ticket>
) {

    fun totalPrice(): Money {
        return Money(tickets.sumOf { it.price.value })
    }

    fun issue() {
        this.tickets.forEach { it.issue() }
    }

    companion object {
        fun from(quantity: Quantity, pricePolicy: PricePolicy, ticketType: TicketType): Tickets {
            val list = mutableListOf<Ticket>()
            repeat(quantity.value.toInt()) {
                val ticket = Ticket(
                    pricePolicy = pricePolicy,
                    lotteryNumbersGenerateStrategy = ticketType.toGenerateStrategy()
                )
                list.add(ticket)
            }
            return Tickets(tickets = list)
        }
    }
}