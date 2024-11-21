package lotto.domain

enum class LottoRank(val matchCount: Int?, val winningMoney: Int) {
    NONE(null, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    fun isWinning(): Boolean = this != NONE

    companion object {
        fun from(matchCount: Int, isBonusMatched: Boolean): LottoRank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (isBonusMatched) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}
