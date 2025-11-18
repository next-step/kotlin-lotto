package domain

class ProfitCalculator {
    fun calculateProfit(
        result: Map<LottoWinningType, Int>,
        purchaseLottoAmount: Int,
    ) = result.map { (key, value) -> key.priceMoney * value }.sum() / purchaseLottoAmount.toDouble()
}
