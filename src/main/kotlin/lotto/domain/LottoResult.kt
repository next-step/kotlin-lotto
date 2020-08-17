package lotto.domain

import lotto.domain.TicketBuilder.Companion.TICKET_COST

class LottoResult(tickets: List<Ticket>, winningTicket: WinningTicket) {
    private val resultMap: Map<Rank, Int> = tickets.groupingBy { it.toRank(winningTicket) }.eachCount()

    private val cost: Int get() = resultMap.values.sum() * TICKET_COST

    operator fun get(rank: Rank): Int {
        return resultMap[rank] ?: 0
    }

    fun collectAllPrizes(): Int {
        return resultMap.toList().sumBy { it.first.sumPrize(it.second) }
    }

    fun totalProfitRate(): Float {
        return collectAllPrizes().toFloat() / (cost).toFloat()
    }
}
