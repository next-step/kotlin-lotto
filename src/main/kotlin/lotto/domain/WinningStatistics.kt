package lotto.domain

data class WinningStatistics(
    val amount: Int,
    val matchCount: Map<Int, Int>,
) {
    val totalPrize: Long = calculateTotalPrize()
    val rate: Double = calculateReturnRate()

    private fun calculateReturnRate(): Double {
        return if (amount == 0) 0.0 else totalPrize.toDouble() / amount
    }

    private fun calculateTotalPrize(): Long {
        return matchCount.entries.sumOf { (matchingNumbers, count) ->
            val prize = WinningPrize.findByMatchCount(matchingNumbers).amount.toLong()
            prize * count
        }
    }
}
