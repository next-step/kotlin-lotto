package domain.winning

import domain.money.Money

enum class WinningCategory(val numberOfMatched: Int, val prize: Money) {
    LOSE(-1, Money.ZERO),
    THREE_CORRECT(3, Money(5_000)),
    FOUR_CORRECT(4, Money(50_000)),
    FIVE_CORRECT(5, Money(1_500_000)),
    FIVE_WITH_BONUS_CORRECT(5, Money(30_000_000)),
    SIX_CORRECT(6, Money(2_000_000_000));

    companion object {
        fun matchNumberOf(numberOfMatched: Int, bonusMatched: Boolean = false): WinningCategory = when {
            numberOfMatched == THREE_CORRECT.numberOfMatched -> THREE_CORRECT
            numberOfMatched == FOUR_CORRECT.numberOfMatched -> FOUR_CORRECT
            numberOfMatched == FIVE_WITH_BONUS_CORRECT.numberOfMatched && bonusMatched -> FIVE_WITH_BONUS_CORRECT
            numberOfMatched == FIVE_CORRECT.numberOfMatched -> FIVE_CORRECT
            numberOfMatched == SIX_CORRECT.numberOfMatched -> SIX_CORRECT
            else -> LOSE
        }
    }
}
