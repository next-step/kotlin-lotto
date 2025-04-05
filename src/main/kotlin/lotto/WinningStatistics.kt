package lotto

class WinningStatistics(lottos: List<Lotto>, winningLotto: WinningLotto) {
    private val rankCount = Rank.entries.associateWith { DEFAULT }.toMutableMap()

    init {
        lottos.forEach {
            val matchCount = winningLotto.matchCount(it)
            val rank = Rank.valueOf(matchCount)
            rankCount[rank] = rankCount[rank]?.plus(PLUS) ?: PLUS
        }
    }

    fun calculateProfit(cost: Double): Double {
        return rankCount.entries.sumOf { (rank, count) -> rank.prize * count } / cost
    }

    fun countBy(rank: Rank): Int {
        return rankCount[rank] ?: DEFAULT
    }

    companion object {
        private const val DEFAULT = 0
        private const val PLUS = 1
    }
}
