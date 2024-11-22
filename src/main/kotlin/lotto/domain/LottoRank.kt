package lotto.domain

enum class LottoRank(val matchCount: Int, val reward: Long) {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    NONE(0, 0), ;

    fun isWin(): Boolean = this != NONE

    companion object {
        fun from(matchCount: Int): LottoRank {
            return entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}
