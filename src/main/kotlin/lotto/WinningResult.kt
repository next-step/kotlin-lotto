package lotto

class WinningResult(
    order: Order,
    winNumbers: Lotto,
) {
    val winningMatchCounts: List<RankResult>
    val revenue: Int
    val rate: Double

    init {
        winningMatchCounts = createRankResults(order, winNumbers)
        revenue = calculateRevenue()
        rate = revenue.toDouble() / order.amount.toDouble()
    }

    private fun calculateRevenue(): Int {
        return winningMatchCounts.sumOf { it.getTotalPrizeMoney() }
    }

    // 3 ~ 6 순서로 정렬된 List를 반환한다.
    private fun createRankResults(
        order: Order,
        winNumbers: Lotto,
    ): List<RankResult> {
        val result = groupByRanks(order, winNumbers)
        return RANK_RANGE.map { rank ->
            RankResult(
                totalCount = result[rank] ?: 0,
                prize = Prize.findByMatchCount(rank),
            )
        }
            .sortedBy { it.prize.matchCount }
    }

    private fun groupByRanks(
        order: Order,
        winNumbers: Lotto,
    ): Map<Int, Int> {
        return order.lottos.map { winNumbers.countMatchingNumbers(it.numbers) }
            .filter { it >= RANK_RANGE.first }
            .groupBy { it }
            .mapValues { (_, values) -> values.size }
    }

    companion object {
        private val RANK_RANGE = IntRange(3, 6)
    }
}
