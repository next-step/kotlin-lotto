package lotto

import lotto.vo.Money

data class GameResult(
    val prizes: List<Pair<Prize, Int>>,
    val paidPrice: Money,
) {
    val profitRate: Double

    init {
        profitRate = calculateTotalPrizeAmount() / paidPrice
    }

    private fun calculateTotalPrizeAmount() = prizes
        .fold(Money(0))
        { prev, (prize, amount) -> prev + prize.amount * amount }
}
