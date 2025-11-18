package domain

class ProfitCalculator(val result: Map<LottoWinningType, Int>, private val purchaseLottoAmount: Int) {
    fun calculateProfit() = result.map { (key, value) -> key.priceMoney * value }.sum() / purchaseLottoAmount.toDouble()
}
