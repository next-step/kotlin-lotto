package lotto.domain

enum class LottoRank(val matchCount: Int, val requiresBonusNumber: Boolean, val prizeAmount: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ;

    companion object {
        private val VALID_MATCH_COUNT = entries.map { rank -> rank.matchCount }

        fun determineRank(matchCount: Int, containsBonusNumber: Boolean): LottoRank {
            if (matchCount == 5 && containsBonusNumber) {
                return SECOND
            }

            return entries.filter { rank -> rank.requiresBonusNumber.not() }
                .find { rank -> rank.matchCount == matchCount }
                ?: throw InvalidLottoRankConditionException(matchCount, containsBonusNumber)
        }

        fun isInTheRank(matchCount: Int): Boolean {
            return VALID_MATCH_COUNT.contains(matchCount)
        }
    }
}
