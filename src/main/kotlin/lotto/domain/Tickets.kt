package lotto.domain

import lotto.controller.WinningNumbers

class Tickets(val tickets: List<Ticket>) {
    val size: Int
        get() = tickets.size

    constructor(numberOfRandomTickets: Int, manualTickets: List<Ticket>)
            : this(generateTicketsWithManualTickets(numberOfRandomTickets, manualTickets))

    fun checkMatches(winningNumbers: WinningNumbers): WinningStatistics {
        val statistics = WinningStatistics()
        for (ticket in tickets) {
            val matches = ticket.checkMatches(winningNumbers)
            val bonusMatches = ticket.checkBonusMatches(winningNumbers)
            statistics.add(matches, bonusMatches)
        }
        return statistics
    }

    companion object {
        private fun generateTickets(amountOfTicket: Int): List<Ticket> {
            return List(amountOfTicket) { Ticket() }
        }

        private fun generateTicketsWithManualTickets(numberOfTickets: Int, manualTickets: List<Ticket>): List<Ticket> {
            val generatedTickets = manualTickets.toMutableList()
            generatedTickets.addAll(generateTickets(numberOfTickets))
            return generatedTickets
        }
    }
}
