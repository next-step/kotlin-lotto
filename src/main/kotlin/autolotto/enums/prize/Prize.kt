package autolotto.enums.prize

enum class Prize(val matchCount: Int, val prizeMoney: Int) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 100000),
    SIX(6, 1000000),
    ;

    open fun calculatePrize(count: Int): Int {
        return count * prizeMoney
    }

    companion object {
        fun fromMatchCount(matchCount: Int): Prize? {
            return entries.find { it.matchCount == matchCount }
        }
    }
}
