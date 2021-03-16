package lotto.result

class WinningResult(
    private val winningStatistics: Map<PrizeRank, Int>
) {

    val totalPrize: Prize = winningStatistics.entries
        .map { it.key.prizeAmount * it.value }
        .reduce { left, right -> left + right }

    fun getPrize(prizeRank: PrizeRank): Int {
        return winningStatistics[prizeRank] ?: 0
    }

    companion object {
        fun aggregate(prizeRanks: List<PrizeRank>): WinningResult {
            return WinningResult(
                winningStatistics = prizeRanks.groupingBy { it }
                    .eachCount()
            )
        }
    }
}

