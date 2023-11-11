package lotto.domain

data class LottoResults(
    val results: List<LottoResult>,
) {
    fun calculateTotalPrize(
        prizeInfo: List<WinningPrize> = LottoSpec.prizesInfo
    ): Amount = results.fold(Amount(0)) { total, result ->
        total + result.calculatePrize(prizeInfo)
    }
}
