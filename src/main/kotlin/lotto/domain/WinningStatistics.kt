package lotto.domain

class WinningStatistics { val matchNumberCounts: MutableMap<Int, Int> = mutableMapOf()

    fun getMatchNumberCount(matchNumber: Int): Int {
        return matchNumberCounts[matchNumber] ?: 0
    }

    fun addMatchNumberCount(matchNumber: Int) {
        val preCount = getMatchNumberCount(matchNumber)
        matchNumberCounts[matchNumber] = preCount + 1
    }
}
