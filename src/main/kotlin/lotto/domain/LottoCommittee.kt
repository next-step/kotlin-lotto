package lotto.domain

import lotto.domain.enum.Priority
import lotto.domain.`interface`.LottoFixedNumbers

object LottoCommittee {
    fun createWinningTicket(input: String): WinningTicket {
        return WinningTicket(LottoTicket(LottoFixedNumbers().createNumbers(input.split(",").map { it.toInt() })))
    }

    fun calculateStatistics(
        lottos: Lottos,
        winningTicket: WinningTicket
    ): Map<Priority, Int> {
        val statistics = initStatistics()
        for (ticket in lottos.tickets) {
            statistics.merge(ticket.priority(winningTicket), 1, Int::plus)
        }
        return statistics
    }

    private fun initStatistics(): MutableMap<Priority, Int> {
        val statistics = mutableMapOf<Priority, Int>()
        for (priority in Priority.values()) {
            statistics[priority] = 0
        }
        return statistics
    }

    fun calculateReturnRate(price: Int, statistics: Map<Priority, Int>): Double {
        return (calculateReturnPrice(statistics) / price.toDouble())
    }

    private fun calculateReturnPrice(statistics: Map<Priority, Int>): Long {
        var returnPrice: Long = 0

        for ((priority, matchCount) in statistics) {
            returnPrice += matchCount * Priority.getPrice(priority.matchCount)
        }

        return returnPrice
    }
}
