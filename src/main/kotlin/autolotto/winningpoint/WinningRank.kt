package autolotto.winningpoint

enum class WinningRank(val matchingCount: Int, val winningPrice: Long) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(3, 50000),
    NOTHING(0, 0)
    ;

    companion object {
        fun of(matchingCount: Int): WinningRank {
            return values().find { it.matchingCount == matchingCount }
                ?: NOTHING
        }
    }
}
