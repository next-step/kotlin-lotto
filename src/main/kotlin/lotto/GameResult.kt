package lotto

import lotto.vo.Money

data class GameResult(
    private val prizes: List<Pair<WinningPrize, Int>>,
    val paidPrice: Money,
) {
    val profitRate: Double

    init {
        profitRate = calculateTotalPrizeAmount().amount / paidPrice.amount.toDouble()
    }

    private fun calculateTotalPrizeAmount() = prizes.fold(Money(0)) { prev, (prize, amount) -> prev + prize.amount * amount }
}
