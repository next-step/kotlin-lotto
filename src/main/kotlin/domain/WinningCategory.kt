package domain

enum class WinningCategory(val numberOfMatched: Int, val prize: Money) {
    THREE_CORRECT(3, Money(5000)),
    FOUR_CORRECT(4, Money(50000)),
    FIVE_CORRECT(5, Money(1500000)),
    SIX_CORRECT(6, Money(2000000000));
}
