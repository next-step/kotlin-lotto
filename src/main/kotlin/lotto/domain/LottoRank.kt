package lotto.domain

enum class LottoRank(
    val matchCount: Int?,
    val winningMoney: Int,
    val condition: LottoRankCondition,
) {
    NONE(null, 0, NoneCondition()),
    FIFTH(3, 5_000, FifthCondition()),
    FOURTH(4, 50_000, FourthCondition()),
    THIRD(5, 1_500_000, ThirdCondition()),
    SECOND(5, 30_000_000, SecondCondition()),
    FIRST(6, 2_000_000_000, FirstCondition()),
    ;

    fun isWinning(): Boolean = this != NONE

    companion object {
        fun from(matchCount: Int, isBonusMatched: Boolean): LottoRank {
            return entries.first { it.condition.match(matchCount, isBonusMatched) }
        }
    }
}
