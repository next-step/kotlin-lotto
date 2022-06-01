package lotto.domain

import lotto.domain.LottoTicket.Companion.NUMBER_SIZE

class TicketMachine(private val numberGenerator: NumberGenerator) {

    fun buy(amount: Int): List<LottoTicket> = buy(amount, emptyList())

    fun buy(amount: Int, manualTickets: List<LottoTicket>): List<LottoTicket> {
        val count = (amount / TICKET_PRICE) - manualTickets.size
        require(count > 0) { "구매할 수 없습니다." }
        return List(count) { LottoTicket(numberGenerator.randomTake(NUMBER_SIZE)) } + manualTickets
    }

    companion object {
        private const val TICKET_PRICE = 1_000
    }
}
