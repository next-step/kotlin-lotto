package lotto

class WinningResult(
    order: Order,
    winNumbers: WinNumbers,
) {
    val winningMatchCounts: Map<Int, Int>
    val revenue: Int
    val rate: Double

    init {
        winningMatchCounts = calculateMatchCounts(order, winNumbers)
        revenue = calculateRevenue()
        rate = (revenue / order.amount).toDouble()
    }

    private fun calculateRevenue(): Int {
        return winningMatchCounts.map { (rank, matchCount) -> getWinningMoney(rank) * matchCount }.sum()
    }

    private fun calculateMatchCounts(
        order: Order,
        winNumbers: WinNumbers,
    ): Map<Int, Int> {
        val result =
            order.lottos.map { winNumbers.countMatchingNumbers(it.numbers) }
                .filter { it >= MIN_RANK }
                .groupBy { it }
                .mapValues { (_, values) -> values.size }
        return (MIN_RANK..MAX_RANK).associateWith { rank -> result[rank] ?: 0 }
    }

    private fun getWinningMoney(matchCount: Int): Int {
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
