package lotto.domain

@JvmInline
value class PrizeStatics(val statics: Map<WinnerPrize, Int>) {
    fun getPrizeMoneyTotal(): Money =
        statics.entries.fold(Money(0)) { total, (prize, cnt) -> total + prize.prizeMoney * cnt }
    operator fun get(winnerPrize: WinnerPrize) = statics[winnerPrize]
}
