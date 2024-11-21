package lotto.domain

enum class LottoRank(
    val matchCount: Int?,
    val winningMoney: Int,
    val condition: (Int, Boolean) -> Boolean,
) {
    NONE(null, 0, { matchCount, _ -> matchCount < 3 }),
    FIFTH(3, 5_000, { matchCount, _ -> matchCount == 3 }),
    FOURTH(4, 50_000, { matchCount, _ -> matchCount == 4 }),
    THIRD(5, 1_500_000, { matchCount, isBonusMatched -> matchCount == 5 && !isBonusMatched }),
    SECOND(5, 30_000_000, { matchCount, isBonusMatched -> matchCount == 5 && isBonusMatched }),
    FIRST(6, 2_000_000_000, { matchCount, _ -> matchCount == 6 }),
    ;

    fun isWinning(): Boolean = this != NONE

    companion object {
        fun from(matchCount: Int, isBonusMatched: Boolean): LottoRank {
            return entries.first { it.condition(matchCount, isBonusMatched) }
        }
    }
}
