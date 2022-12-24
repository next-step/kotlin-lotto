package lotto.domain

import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney
import lotto.common.value.Quantity
import lotto.domain.enums.TicketType
import lotto.domain.policy.PricePolicy
import lotto.domain.vo.LotteryNumbers

class Tickets(
    private val tickets: List<Ticket>
) {

    fun totalPrice(): Money {
        return tickets.sumOf { it.price.value }.toMoney()
    }

    fun issue() {
        this.tickets.forEach { it.issue() }
    }

    fun toLotteryNumbers(): List<LotteryNumbers> = this.tickets.map { it.lotteryNumbers }
    fun size(): Int = this.tickets.size

    companion object {
        fun from(quantity: Quantity, pricePolicy: PricePolicy, ticketType: TicketType): Tickets {
            val list = List(quantity.value) {
                Ticket(
                    pricePolicy = pricePolicy,
                    lotteryNumbersGenerateStrategy = ticketType.toGenerateStrategy()
                )
            }
            return Tickets(tickets = list)
        }
    }
}
