package lotto.domain

enum class WinnerPrize(val matchCount: Int, val prizeMoney: Money) {
    FIRST_PRIZE(6, Money(2_000_000_000)),
    SECOND_PRIZE(5, Money(1_500_000)),
    THIRD_PRIZE(4, Money(50_000)),
    FOURTH_PRIZE(3, Money(5_000)),
    NOTHING(0, Money(0));

    companion object {
        private val WINNER_PRIZE_MAP = WinnerPrize.values().associateBy { it.matchCount }
        fun getWinnerPrize(matchCount: Int): WinnerPrize = WINNER_PRIZE_MAP[matchCount] ?: NOTHING
    }
}
