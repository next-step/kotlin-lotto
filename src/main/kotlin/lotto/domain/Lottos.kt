package lotto.domain

class Lottos(
    val values: List<Lotto>,
) {
    val size = values.size
    val cost = size * Lotto.PRICE

    fun calculateResults(winningNumbers: WinningNumbers): LottosResult {
        val winningResults = values
            .map { lotto -> lotto.calculateResult(winningNumbers) }
            .groupingBy { it }
            .eachCount()
            .fillMissingRanks()

        return LottosResult(
            totalCost = cost,
            winningResults = winningResults,
        )
    }

    private fun Map<Rank, Int>.fillMissingRanks(): Map<Rank, Int> {
        return Rank.values()
            .filter { it !in this.keys }
            .fold(this) { acc, rank ->
                acc + (rank to 0)
            }
    }
}
