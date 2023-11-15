package lotto.domain

import lotto.`interface`.TicketGenerationStrategy
import lotto.`interface`.impl.AutomaticTicketGenerationStrategy
import lotto.`interface`.impl.ManualTicketGenerationStrategy

class LottoMachine(private val ticketPrice: Int) {

    fun generateTickets(amount: Int, manualNumbersList: List<List<Int>>? = null): Pair<Int, List<LottoTicket>> {
        val totalTicketCount = amount / ticketPrice
        val manualTickets = manualNumbersList?.let { generateTickets(it, ::ManualTicketGenerationStrategy) } ?: listOf()
        val automaticTicketCount = totalTicketCount - manualTickets.size
        val automaticTickets = lottoTickets(automaticTicketCount)
        return Pair(manualNumbersList?.size ?: 0, manualTickets + automaticTickets)
    }

    private fun lottoTickets(automaticTicketCount: Int): List<LottoTicket> {
        val automaticTickets = generateAutomaticTickets(automaticTicketCount)
        return automaticTickets
    }

    private fun generateTickets(numbersList: List<List<Int>>, strategy: (List<Int>) -> TicketGenerationStrategy): List<LottoTicket> {
        return numbersList.map { strategy(it).generate() }
    }

    private fun generateAutomaticTickets(count: Int): List<LottoTicket> {
        return List(count) { AutomaticTicketGenerationStrategy().generate() }
    }
}
