package lotto.domain

import lotto.domain.TicketBuyer.Companion.TICKET_COST

class LottoResult {
    val cost: Int get() = resultMap.size * TICKET_COST

    private val resultMap = hashMapOf<Rank, Int>()

    operator fun get(rank: Rank): Int {
        return resultMap[rank] ?: 0
    }

    operator fun set(rank: Rank, value: Int) {
        resultMap[rank] = value
    }

    fun collectAllPrizes(): Int {
        return resultMap.toList().sumBy { it.first.sumPrize(it.second) }
    }
}
