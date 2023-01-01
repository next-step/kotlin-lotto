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
    fun size(ticketType: TicketType) = this.tickets.filter { it.ticketType == ticketType }.size

    companion object {
        fun of(quantity: Quantity, pricePolicy: PricePolicy, ticketType: TicketType, lotteryNumbers: List<LotteryNumbers> = listOf()): Tickets {
            val list = List(quantity.value) {
                when(ticketType) {
                    TicketType.AUTO -> Ticket(
                        pricePolicy = pricePolicy,
                        lotteryNumbersGenerateStrategy = ticketType.toGenerateStrategy(),
                        ticketType = TicketType.AUTO
                    )
                    TicketType.MANUAL -> Ticket(
                        pricePolicy = pricePolicy,
                        lotteryNumbersGenerateStrategy = ticketType.toGenerateStrategy(lotteryNumbers[it]),
                        ticketType = TicketType.MANUAL
                    )
                }
            }
            return Tickets(tickets = list)
        }

        fun merge(ticketList: List<Tickets>): Tickets {
            val mergedTicketList = ticketList.map { it.tickets }.flatten()
            return Tickets(mergedTicketList)
        }
    }
}
