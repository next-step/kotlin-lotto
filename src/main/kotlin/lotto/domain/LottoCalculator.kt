package lotto.domain

class LottoCalculator {
    fun calculateLottoCount(
        totalPurchaseAmount: Int,
        pricePerAmount: Int,
    ): Int {
        require(pricePerAmount > 0) { "invalid pricePerAmount : $pricePerAmount" }
        return totalPurchaseAmount / pricePerAmount
    }
}
