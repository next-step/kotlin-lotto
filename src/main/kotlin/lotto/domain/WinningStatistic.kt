package lotto.domain

class WinningStatistic(
    prizes: List<Prize>,
    purchaseAmount: Long,
) {
    private val totalWinningAmount: Long = prizes.sumOf { it.winningAmount }

    val profitRate: Double = totalWinningAmount / purchaseAmount.toDouble()

    val countPerPrize: Map<Prize, Int> = prizes.groupingBy { it }
        .eachCount()
}
