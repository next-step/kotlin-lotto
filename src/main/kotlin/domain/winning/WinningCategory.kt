package domain.winning

import domain.money.Money

enum class WinningCategory(val prize: Money) {
    LOSE(Money.ZERO),
    THREE_CORRECT(Money(5_000)),
    FOUR_CORRECT(Money(50_000)),
    FIVE_CORRECT(Money(1_500_000)),
    FIVE_WITH_BONUS_CORRECT(Money(30_000_000)),
    SIX_CORRECT(Money(2_000_000_000));

    companion object {
        fun matchNumberOf(numberOfMatched: Int, bonusMatched: Boolean = false): WinningCategory = when {
            numberOfMatched == 3 -> THREE_CORRECT
            numberOfMatched == 4 -> FOUR_CORRECT
            numberOfMatched == 5 && bonusMatched -> FIVE_WITH_BONUS_CORRECT
            numberOfMatched == 5 -> FIVE_CORRECT
            numberOfMatched == 6 -> SIX_CORRECT
            else -> LOSE
        }
    }
}
