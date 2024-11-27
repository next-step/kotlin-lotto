package lotto.domain

enum class WinningCategory(val matchCount: Int, val prize: Int) {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    companion object {
        fun fromMatchCount(count: Int): WinningCategory {
            return entries.find { it.matchCount == count } ?: NONE
        }
    }
}
