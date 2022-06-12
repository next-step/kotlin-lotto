package lotto.domain

import lotto.domain.enums.Priority
import lotto.domain.interfaces.LottoNumberGenerator

object LottoCommittee {
    fun createWinningTicket(input: String, bonusBall: String): WinningTicket {
        val lottoNumbers = LottoNumberGenerator().convertLottoNumbers(input.split(",").map { it.toInt() })
        val lottoTicket = LottoTicket(lottoNumbers)
        return WinningTicket(lottoTicket, bonusBall.toInt())
    }

    fun calculateStatistics(
        lottos: Lottos,
        winningTicket: WinningTicket
    ): Map<Priority, Int> {
        val priorities = initializePriorities()

        val ticketCounts: Map<LottoTicket, Int> =
            lottos.tickets.associateWith { ticket -> winningTicket.calculateMatch(ticket) }

        ticketCounts
            .filter { winningTicket.isBonusTicket(it.key, it.value) }
            .map { priorities.merge(Priority.SECOND, 1, Int::plus) }

        ticketCounts
            .filter { !winningTicket.isBonusTicket(it.key, it.value) }
            .map { priorities.merge(Priority.find(it.value), 1, Int::plus) }

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
