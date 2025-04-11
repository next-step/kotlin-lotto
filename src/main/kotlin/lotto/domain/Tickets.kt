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
            val matches = checkMatches(winningNumbers, ticket)
            val bonusMatches = checkBonusMatches(winningNumbers, ticket)
            statistics.add(matches, bonusMatches)
        }
        return statistics
    }

    private fun checkMatches(winningNumbers: WinningNumbers, ticket: Ticket): Int{
        return winningNumbers.numbers.intersect(ticket.lottoNumber).size
    }

    private fun checkBonusMatches(winningNumbers: WinningNumbers, ticket: Ticket): Boolean {
        return ticket.contains(winningNumbers.bonusNumber)
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
