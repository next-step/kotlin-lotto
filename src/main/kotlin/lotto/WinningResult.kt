import lotto.Rank

class WinningResult(private val winningStatistics: Map<Int, Int>) {
    fun calculateTotalPrize(): Int {
        return winningStatistics.entries.sumOf { (matchCount, count) ->
            calculatePrizeForMatch(matchCount, count)
        }
    }

    private fun calculatePrizeForMatch(
        matchCount: Int,
        count: Int,
    ): Int {
        val rank = Rank.from(matchCount)
        return rank.prize * count
    }

    // 손익률 계산
    fun calculateProfitRate(purchaseAmount: Int): Double {
        return calculateTotalPrize().toDouble() / purchaseAmount
    }

    fun getWinningCount(matchCount: Int): Int {
        return winningStatistics.getOrDefault(matchCount, 0)
    }
}
