package lotto.domain

class WinningStatistic(
    prizes: List<Prize>,
    purchaseAmount: Won,
) {
    private val totalWinningAmount: Long = prizes.sumOf { it.winningAmount.amount }

    val profitRate: Double = totalWinningAmount / purchaseAmount.amount.toDouble()

    val countPerPrize: Map<Prize, Int> = prizes.groupingBy { it }
        .eachCount()
}
