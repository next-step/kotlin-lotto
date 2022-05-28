package lotto.domain

import lotto.domain.LottoTicket.Companion.NUMBER_SIZE

class TicketMachine(private val numberGenerator: NumberGenerator) {

    fun buy(amount: Int): List<LottoTicket> {
        val tickets = mutableListOf<LottoTicket>()
        repeat(amount / TICKET_PRICE) { tickets += LottoTicket(numberGenerator.randomTake(NUMBER_SIZE)) }
        return tickets.toList()
    }

    companion object {
        private const val TICKET_PRICE = 1_000
    }
}
