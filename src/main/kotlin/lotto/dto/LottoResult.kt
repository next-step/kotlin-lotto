package lotto.dto

import lotto.domain.LottoConstants
import lotto.domain.LottoTicket

class LottoResult(private val tickets: List<LottoTicket>, private val winningNumbers: Set<Int>) {
    private val matchCount = mutableMapOf<Int, Int>()

    init {
        calculateMatchCount()
    }

    private fun calculateMatchCount() {
        for (ticket in tickets) {
            val count = ticket.getMatchingNumbersCount(winningNumbers)
            matchCount[count] = matchCount.getOrDefault(count, 0) + 1
        }
    }

    fun getMatchCount(match: Int): Int? {
        return matchCount[match]
    }

    fun calculateRevenue(): Double {
        var revenue = 0.0
        matchCount.forEach { (match, count) ->
            revenue += when (match) {
                3 -> LottoConstants.getPrizeMatch3().toDouble() * count
                4 -> LottoConstants.getPrizeMatch4().toDouble() * count
                5 -> LottoConstants.getPrizeMatch5().toDouble() * count
                6 -> LottoConstants.getPrizeMatch6().toDouble() * count
                else -> 0.0
            }
        }
        return revenue
    }

    fun calculateReturnRate(purchaseAmount: Double): Double {
        val revenue = calculateRevenue()
        return revenue / purchaseAmount
    }
}
