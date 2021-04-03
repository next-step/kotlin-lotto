package lotto.domain

class Profit(private val prizeRankCount: Map<LottoPrize, PositiveNumber>, private val purchaseAmount: Money) {

    fun rate(): Double {
        val allRewards = prizeRankCount.entries
            .sumByMoney { (lottoPrize, count) -> lottoPrize.reward * count }
        return allRewards.rateOf(purchaseAmount).toDouble()
    }
}

private inline fun <T> Iterable<T>.sumByMoney(selector: (T) -> Money): Money {
    return map { selector(it) }.fold(Money.EMPTY) { acc, money -> acc + money }
}
