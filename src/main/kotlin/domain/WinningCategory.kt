package domain

enum class WinningCategory(val numberOfMatched: Int) {
    THREE_CORRECT(3),
    FOUR_CORRECT(4),
    FIVE_CORRECT(5),
    SIX_CORRECT(6);
}
