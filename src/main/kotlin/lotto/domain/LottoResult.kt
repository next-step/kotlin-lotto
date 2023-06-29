package lotto.domain

data class LottoResult(
    val result: Map<Rank, Int>
) {
    fun getTotalPrize(): Long {
        return result.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
    }

    private fun getPurchasePrice(): Int =
        result.values.sum() * 1000

    fun getRateOfReturn(): Double =
        (getTotalPrize() * 100.0 / getPurchasePrice()) / 100.0
}
