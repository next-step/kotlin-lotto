package lotto

class WinningResult(
    order: Order,
    winNumbers: WinNumbers,
) {
    val winningMatchCounts: List<Rank>
    val revenue: Int
    val rate: Double

    init {
        winningMatchCounts = createRankResults(order, winNumbers)
        revenue = calculateRevenue()
        rate = revenue.toDouble() / order.amount.toDouble()
    }

    private fun calculateRevenue(): Int {
        return winningMatchCounts.map { (rank, matchCount) -> getPrizeMoney(rank) * matchCount }.sum()
    }

    // 3 ~ 6 순서로 정렬된 List를 반환한다.
    private fun createRankResults(
        order: Order,
        winNumbers: WinNumbers,
    ): List<Rank> {
        val result = groupByRanks(order, winNumbers)
        return (MIN_RANK..MAX_RANK)
            .map { rank -> Rank(rank, result[rank] ?: 0, getPrizeMoney(rank)) }
            .sortedBy { it.rank }
    }

    private fun groupByRanks(
        order: Order,
        winNumbers: WinNumbers,
    ): Map<Int, Int> {
        return order.lottos.map { winNumbers.countMatchingNumbers(it.numbers) }
            .filter { it >= MIN_RANK }
            .groupBy { it }
            .mapValues { (_, values) -> values.size }
    }

    private fun getPrizeMoney(matchCount: Int): Int {
        return when (matchCount) {
            6 -> FIRST_PRIZE
            5 -> SECOND_PRIZE
            4 -> THIRD_PRIZE
            3 -> FOURTH_PRIZE
            else -> 0
        }
    }

    companion object {
        private const val MIN_RANK = 3
        private const val MAX_RANK = 6
        private const val FIRST_PRIZE = 2_000_000_000
        private const val SECOND_PRIZE = 1_500_000
        private const val THIRD_PRIZE = 50_000
        private const val FOURTH_PRIZE = 5_000
    }
}
