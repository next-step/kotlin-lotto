package lotto.domain

class Lottos(
    val values: List<Lotto>,
) {
    val size = values.size
    val cost = size * Lotto.PRICE

    fun calculateResults(winningNumbers: LottoNumbers): LottosResult {
        val winningResults = values
            .map { lotto -> lotto.calculateResult(winningNumbers) }
            .filterNotNull()
            .groupingBy { it }
            .eachCount()
            .fillMissingRanks()

        return LottosResult(
            totalCost = cost,
            winningResults = winningResults,
        )
    }

    private fun Map<LottoRank, Int>.fillMissingRanks(): Map<LottoRank, Int> {
        return LottoRank.values()
            .filter { it !in this.keys }
            .fold(this) { acc, rank ->
                acc + (rank to 0)
            }
    }
}
