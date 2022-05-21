package lotto.domain.enums

typealias RankMatching = (Boolean, Boolean) -> Boolean

enum class LottoRank(
    val matchingCount: Int,
    val rewardPrice: Long,
    private val isMatch: RankMatching = { isMatchCount, _ -> isMatchCount }
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, { isMatchCount, isMatchBonus -> isMatchCount && isMatchBonus }),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, 0);

    fun sumOfPrice(numberOfLotto: Int): Long {
        return rewardPrice * numberOfLotto
    }

    private fun isMatchCount(matchingCount: Int): Boolean {
        return this.matchingCount == matchingCount
    }

    companion object {
        fun of(matchingCount: Int, isMatchBonusNumber: Boolean): LottoRank {
            return values().find { it.isMatch(it.isMatchCount(matchingCount), isMatchBonusNumber) } ?: NONE
        }
    }
}
