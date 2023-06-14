package lotto.domain

data class PrizeStatics(private val statics: Map<WinnerPrize, Int>) : Map<WinnerPrize, Int> by statics {
    fun getPrizeMoneyTotal(): Money =
        statics.entries.fold(Money(0)) { total, (prize, cnt) -> total + prize.prizeMoney * cnt }
}
