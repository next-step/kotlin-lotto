package domain

enum class WinningCategory(val numberOfMatched: Int, val prize: Money) {
    THREE_CORRECT(3, Money(5_000)),
    FOUR_CORRECT(4, Money(50_000)),
    FIVE_CORRECT(5, Money(1_500_000)),
    SIX_CORRECT(6, Money(2_000_000_000));
}
