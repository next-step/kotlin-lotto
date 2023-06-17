package lotto.domain

enum class WinResult(val matchCount: Int, val reward: Long) {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    LOSE(0, 0),
    ;

    companion object {
        fun valueOfMatchCount(matchCount: Int): WinResult {
            return values().firstOrNull { matchCount == it.matchCount } ?: LOSE
        }
    }
}
