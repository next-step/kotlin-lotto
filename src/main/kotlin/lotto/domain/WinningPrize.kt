package lotto.domain

enum class WinningPrize(val matchCount: Int, val amount: Int) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    DEFAULT(0, 0),
    ;

    companion object {
        fun findByMatchCount(matchCount: Int): WinningPrize {
            return entries.find { it.matchCount == matchCount } ?: return DEFAULT
        }
    }
}
