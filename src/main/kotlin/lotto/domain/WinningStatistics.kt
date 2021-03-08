package lotto.domain

import lotto.enums.LotteryMatchType

class WinningStatistics {
    val ticketCounts: MutableMap<LotteryMatchType, Int> = mutableMapOf()

    fun getTicketCountOf(matchType: LotteryMatchType): Int {
        return ticketCounts[matchType] ?: 0
    }

    fun addTicketCountOf(matchType: LotteryMatchType) {
        val preCount = getTicketCountOf(matchType)
        ticketCounts[matchType] = preCount + 1
    }

    fun calculateTotalWinningPrice(): Int {
        var winningPrice = 0
        for (entry in ticketCounts) {
            val lotteryMatchType = entry.key
            val ticketCount = entry.value

            winningPrice += lotteryMatchType.winningPrice * ticketCount
        }
        return winningPrice
    }
}
