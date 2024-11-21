package lotto.domain

enum class LottoRank(val matchCount: Int?, val winningMoney: Int) {
    NONE(null, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    fun isWinning(): Boolean = this != NONE

    companion object {
        fun from(matchCount: Int): LottoRank {
            return entries.find { it.matchCount == matchCount } ?: NONE
        }
    }
}
