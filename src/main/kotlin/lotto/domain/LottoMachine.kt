package lotto.domain

import lotto.dto.LottoTicketsResult
import lotto.dto.ManualLottoTickets
import lotto.`interface`.impl.AutomaticTicketGenerationStrategy

class LottoMachine(private val ticketPrice: Int) {

    fun generateTickets(amount: Int, manualTickets: ManualLottoTickets? = null): LottoTicketsResult {
        val totalTicketCount = amount / ticketPrice
        val manualLottoTickets = manualTickets?.tickets ?: listOf()
        val automaticTicketCount = totalTicketCount - manualLottoTickets.size
        val automaticTickets = generateAutomaticTickets(automaticTicketCount)
        return LottoTicketsResult(manualLottoTickets.size, manualLottoTickets + automaticTickets)
    }

    private fun generateAutomaticTickets(count: Int): List<LottoTicket> {
        return List(count) { AutomaticTicketGenerationStrategy().generate() }
    }
}
