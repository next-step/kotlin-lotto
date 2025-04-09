package lotto.view

import lotto.domain.MatchPrize
import lotto.domain.Ticket
import lotto.domain.Tickets
import lotto.domain.WinningStatistics

class ResultView {
    fun printTickets(tickets: Tickets) {
        println("You have purchased ${tickets.size}")
        for (ticket in tickets.tickets) {
            printTicket(ticket)
        }
    }

    private fun printTicket(ticket: Ticket) {
        println(ticket.lottoNumber.map { it.number }
            .joinToString(", ", "[", "]"))
    }
    fun printWinningStatistics(winningStatistics: WinningStatistics, rate: Double) {
        println("\nWinning Statistics\n------------------")
        for(prize in MatchPrize.entries) {
            println("${prize.matchCount} Matches " +
                    (if (prize.usingBonus) "+ Bonus Ball " else "") +
                    "(${prize.price} KRW) - ${winningStatistics.get(prize.matchCount, prize.usingBonus)} tickets")
        }
        println("Total return rate is $rate (A rate below 1 means a loss)")
    }
}
