package lotto.domain

class WinningStats(private val money: Int) {
    private val matchStats: MutableMap<Prize, Int> = mutableMapOf()

    fun addMatchCount(prize: Prize) {
        val prevCount = matchStats[prize] ?: 0
        matchStats[prize] = prevCount + 1
    }

    fun getWinningCountByPrize(prize: Prize): Int {
        return matchStats[prize] ?: 0
    }
}
