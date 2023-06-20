package lotto.domain

enum class WinnerPrize(val matchCount: Int, val prizeMoney: Money) {
    FIRST_PRIZE(6, Money(2_000_000_000)),
    SECOND_PRIZE(5, Money(30_000_000)),
    THIRD_PRIZE(5, Money(1_500_000)),
    FOURTH_PRIZE(4, Money(50_000)),
    FIFTH_PRIZE(3, Money(5_000)),
    NOTHING(0, Money(0));

    companion object {
        fun getWinnerPrize(matchCount: Int, matchBonus: Boolean): WinnerPrize = when {
            FIRST_PRIZE.matchCount == matchCount -> FIRST_PRIZE
            SECOND_PRIZE.matchCount == matchCount && matchBonus -> SECOND_PRIZE
            THIRD_PRIZE.matchCount == matchCount -> THIRD_PRIZE
            FOURTH_PRIZE.matchCount == matchCount -> FOURTH_PRIZE
            FIFTH_PRIZE.matchCount == matchCount -> FIFTH_PRIZE
            else -> NOTHING
        }
    }
}
