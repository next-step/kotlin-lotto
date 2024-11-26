package lotto.domain

class LottoCalculator(
    private val totalPurchaseAmount: Int,
    private val pricePerAmount: Int,
) {
    fun calculateLottoCount(): Int {
        require(pricePerAmount > 0) { "invalid pricePerAmount : $pricePerAmount" }
        return totalPurchaseAmount / pricePerAmount
    }

    fun calculateWinningRateFromResult(totalWinCount: Int): Double {
        return totalWinCount.toDouble() / totalPurchaseAmount
    }
}
