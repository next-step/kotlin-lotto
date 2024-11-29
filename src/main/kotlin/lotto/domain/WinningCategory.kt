package lotto.domain

enum class WinningCategory(val matchCount: Int, val prize: Int) {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    ;

    companion object {
        fun fromMatchCount(count: Int): WinningCategory {
            return entries.find { it.matchCount == count } ?: NONE
        }
    }
}
