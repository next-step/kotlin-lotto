package lotto.domain

data class LottoResult(
    val result: Map<Int, LottoList>
) {
    fun getTotalPrize(): Long {
        return prizeMoneyMap.entries
            .sumOf { (matchingCount, prize) ->
                prize * (result[matchingCount]?.size() ?: 0)
            }
    }

    private fun getPurchasePrice(): Long =
        result.values.flatMap { it.lottos }.size * 1000L

    fun getRateOfReturn(): Double =
        (getTotalPrize() * 100.0 / getPurchasePrice()) / 100.0

    companion object {
        val prizeMoneyMap = mapOf(
            3 to 5000L,
            4 to 50000L,
            5 to 1500000L,
            6 to 2000000000L
        )
    }
}
