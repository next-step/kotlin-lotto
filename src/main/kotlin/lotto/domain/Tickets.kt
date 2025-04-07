package lotto.domain

import lotto.controller.WinningNumbers

class Tickets(val tickets: List<Ticket>) {
    val size: Int
        get() = tickets.size

    constructor(amountOfTicket: Int) : this(generateTickets(amountOfTicket))

    fun checkMatches(winningNumbers: WinningNumbers, statistics: WinningStatistics) {
        for (ticket in tickets) {
            val matches = checkMatches(winningNumbers, ticket)
            statistics.add(matches)
        }
    }

    private fun checkMatches(winningNumbers: WinningNumbers, ticket: Ticket): Int{
        return winningNumbers.numbers.intersect(ticket.lottoNumber).size
    }

    companion object {
        private fun generateTickets(amountOfTicket: Int): List<Ticket> {
            return List(amountOfTicket) { Ticket() }
        }
    }
}
