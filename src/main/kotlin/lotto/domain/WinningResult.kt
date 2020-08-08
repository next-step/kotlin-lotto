package lotto.domain

object WinningResult {
    private val mWinningResult: MutableMap<Rank, Int> = mutableMapOf(
        Rank.FIFTH to 0,
        Rank.FOURTH to 0,
        Rank.THIRD to 0,
        Rank.SECOND to 0,
        Rank.FIRST to 0
    )
    private val winningResult: Map<Rank, Int>
        get() = mWinningResult

    fun resultOfRanks(ranks: List<Rank>): Map<Rank, Int> {
        ranks.filterNot { it == Rank.ELSE }
            .forEach { addRankToResult(it) }
        return winningResult
    }

    private fun addRankToResult(it: Rank) {
        mWinningResult[it] = mWinningResult.getValue(it) + 1
    }

    fun sumOfPrizeMoney(): Int {
        return winningResult.map { it.key.prizeMoney * it.value }.sumBy { it }
    }
}
