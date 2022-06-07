package lotto.domain

import lotto.domain.enum.Priority
import lotto.domain.`interface`.LottoFixedNumbers

object LottoCommittee {
    fun createWinningTicket(input: String, bonusBall: String): WinningTicket {
        val lottoTicket = LottoTicket(LottoFixedNumbers().createNumbers(input.split(",").map { it.toInt() }))
        return WinningTicket(lottoTicket, bonusBall.toInt())
    }

    fun calculateStatistics(
        lottos: Lottos,
        winningTicket: WinningTicket
    ): Map<Priority, Int> {
        val priorities = initializePriorities()
        for (ticket in lottos.tickets) {
            val countOfMatch = winningTicket.calculateMatch(ticket)

            if (winningTicket.isBonusTicket(ticket, countOfMatch)) {
                priorities.merge(Priority.SECOND, 1, Int::plus)
                continue
            }

            priorities.merge(Priority.find(countOfMatch), 1, Int::plus)
        }

        return priorities
    }

    private fun initializePriorities(): MutableMap<Priority, Int> {
        val priorities = mutableMapOf<Priority, Int>()

        for (priority in Priority.values()) {
            priorities[priority] = 0
        }

        return priorities
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
