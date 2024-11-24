package lotto.domain

enum class LottoRank(val matchCount: Int, val containBonus: Boolean, val reward: Long) {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 1_500_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0),
    ;

    fun isWin(): Boolean = this != NONE

    companion object {
        fun from(
            matchCount: Int,
            containBonus: Boolean,
        ): LottoRank {
            if (containBonus) {
                return entries.firstOrNull { it.matchCount == matchCount && it.containBonus } ?: NONE
            }

            return entries.firstOrNull { it.matchCount == matchCount && !it.containBonus } ?: NONE
        }
    }
}
