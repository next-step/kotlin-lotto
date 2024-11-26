package lotto.domain

enum class LottoRank(
    val rank: Int,
    val prize: Int,
    val matchCount: Int,
    val isBonusRequired: Boolean = false,
) {
    FIRST(1, 2_000_000_000, 6),
    SECOND(2, 30_000_000, 5, true),
    THIRD(3, 1_500_000, 5),
    FOURTH(4, 50_000, 4),
    FIFTH(5, 5_000, 3),
    NO_RANK(6, 0, 0),
    ;

    companion object {
        fun fromMatchAndBonus(
            matchCount: Int,
            bonusMatch: Boolean,
        ): LottoRank {
            return entries.firstOrNull { it.matches(matchCount, bonusMatch) } ?: NO_RANK
        }
    }

    private fun matches(
        matchCount: Int,
        bonusMatch: Boolean,
    ): Boolean {
        return this.matchCount == matchCount && (!isBonusRequired || (isBonusRequired && bonusMatch))
    }
}
