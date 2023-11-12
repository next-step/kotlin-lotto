package autolotto.winningpoint

enum class WinningRank(val matchingCount: Int, val winningPrice: Long, val isBonusNumberNeeded: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0)
    ;

    companion object {
        fun of(matchingCount: Int, isMatchedBonusNumber: Boolean): WinningRank {
            if(matchingCount == 5) {
                return values().find { it.matchingCount == matchingCount && it.isBonusNumberNeeded == isMatchedBonusNumber } ?: NOTHING
            }
            return values().find { it.matchingCount == matchingCount } ?: NOTHING
        }

        fun isWinningRank(winningRank: WinningRank): Boolean {
            return winningRank != NOTHING
        }
    }
}
