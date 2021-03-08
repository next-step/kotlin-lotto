package lotto.domain

import lotto.enums.LotteryMatchType

class WinningStatistics {
    val matchNumberCounts: MutableMap<LotteryMatchType, Int> = mutableMapOf()

    fun getTicketCountOf(matchType: LotteryMatchType): Int {
        return matchNumberCounts[matchType] ?: 0
    }

    fun addTicketCountOf(matchType: LotteryMatchType) {
        val preCount = getTicketCountOf(matchType)
        matchNumberCounts[matchType] = preCount + 1
    }
}
