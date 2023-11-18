package specific.lotto.domain

data class WinningResult(val ranks: List<Rank>) {

    val aggregatedData: Map<Rank, Int> = aggregate()

    val totalPrize: Long = calculateTotalPrize()

    private fun aggregate(): Map<Rank, Int> {
        return ranks
                .groupBy { it }
                .mapValues { (_, tickets) -> tickets.size }
    }

    private fun calculateTotalPrize() =
        aggregatedData.entries.fold(0L) { sum, (rank, count) -> sum + rank.prize * count }

}
