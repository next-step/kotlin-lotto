package lotto.domain

enum class WinningPrize(val matchCount: Int, val amount: Int) {
    THREE(3, 5000),
    FOUR(4, 5_0000),
    FIVE(5, 150_0000),
    SIX(6, 20_0000_0000),
    DEFAULT(0, 0),
    ;

    companion object {
        fun findByMatchCount(matchCount: Int): WinningPrize {
            return entries.find { it.matchCount == matchCount } ?: return DEFAULT
        }
    }
}
