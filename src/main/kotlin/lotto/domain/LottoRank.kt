package lotto.domain

enum class LottoRank(val matchCount: Int, val requiresBonusNumber: Boolean, val prizeAmount: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    UNRANKED(-1, false, 0),
    ;

    companion object {
        fun determineRank(matchCount: Int, containsBonusNumber: Boolean): LottoRank {
            if (matchCount == 5 && containsBonusNumber) {
                return SECOND
            }

            return entries.filter { rank -> rank.requiresBonusNumber.not() }
                .find { rank -> rank.matchCount == matchCount }
                ?: UNRANKED
        }
    }
}
