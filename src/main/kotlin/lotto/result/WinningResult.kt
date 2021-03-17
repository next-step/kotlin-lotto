package lotto.result

class WinningResult(
    private val winningStatistics: Map<Rank, Int>
) {

    val totalPrize: Prize = winningStatistics.entries
        .map { it.key.prizeAmount * it.value }
        .reduce { left, right -> left + right }
        .toPrize()

    fun findRankCount(rank: Rank): Int {
        return winningStatistics[rank] ?: 0
    }

    companion object {
        fun aggregate(ranks: List<Rank>): WinningResult {
            return WinningResult(
                winningStatistics = ranks.groupingBy { it }
                    .eachCount()
            )
        }
    }
}
