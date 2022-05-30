package lotto.domain

import lotto.domain.LottoTicket.Companion.NUMBER_SIZE

class TicketMachine(private val numberGenerator: NumberGenerator) {

    fun buy(amount: Int): List<LottoTicket> =
        List(amount / TICKET_PRICE) { LottoTicket(numberGenerator.randomTake(NUMBER_SIZE)) }

    companion object {
        private const val TICKET_PRICE = 1_000
    }
}
