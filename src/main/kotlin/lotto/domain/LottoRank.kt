package lotto.domain

enum class LottoRank(val matchCount: Int, val reward: Long) {
    FIRST(6, 2000000000L),
    SECOND(5, 1500000L),
    THIRD(4, 50000L),
    FOURTH(3, 5000L),
    NONE(0, 0), ;

    fun isWin(): Boolean = this != NONE

    companion object {
        fun from(matchCount: Int): LottoRank {
            return entries.firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}
