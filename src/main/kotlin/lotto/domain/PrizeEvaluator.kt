package lotto.domain

import lotto.domain.enums.RANK


object PrizeEvaluator {
    fun evaluate(userTicket: Ticket, winningTicket: Ticket): Prize {
        val prize = when (userTicket.countSameNumber(winningTicket)) {
            RANK.FOURTH.sameNumber -> RANK.FOURTH.prize
            RANK.THIRD.sameNumber -> RANK.THIRD.prize
            RANK.SECOND.sameNumber -> RANK.SECOND.prize
            RANK.FIRST.sameNumber -> RANK.FIRST.prize
            else -> Prize(0)
        }

        return prize
    }

    fun evaluateTotalPrize(tickets: List<Ticket>, winningTicket: Ticket): Prize {
        return Prize(tickets.sumOf { ticket -> evaluate(ticket, winningTicket).value })
    }

    fun calculateROI(prize: Prize, ticketPrice: Int): Double {
        return prize.value.toDouble() / ticketPrice
    }
}
