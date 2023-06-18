package lotto.domain

class Lottos(
    val values: List<Lotto>,
) {
    val size = values.size
    val cost = size * Lotto.PRICE

    fun calculateResults(winningNumbers: LottoNumbers): LottosResult {
        val results = LottoRank.createMapWithLottoRankAndZero()
        values.forEach { lotto ->
            val lottoRank = lotto.calculateResult(winningNumbers) ?: return@forEach
            results[lottoRank] = results[lottoRank]?.plus(1) ?: 0
        }

        return LottosResult(
            totalCost = cost,
            winningResults = results.toMap(),
        )
    }
}
