package domain.statistics

import domain.money.Money

enum class WinningCategory(val numberOfMatched: Int, val prize: Money) {
    THREE_CORRECT(3, Money(5_000)),
    FOUR_CORRECT(4, Money(50_000)),
    FIVE_CORRECT(5, Money(1_500_000)),
    FIVE_CORRECT_WITH_BONUS(5, Money(30_000_000)),
    SIX_CORRECT(6, Money(2_000_000_000));

    companion object {
        fun matchNumberOf(numberOfMatched: Int): WinningCategory? = when (numberOfMatched) {
            3 -> THREE_CORRECT
            4 -> FOUR_CORRECT
            5 -> FIVE_CORRECT
            6 -> SIX_CORRECT
            else -> null
        }
    }
}
