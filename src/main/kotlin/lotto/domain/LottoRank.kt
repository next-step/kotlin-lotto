package lotto.domain

enum class LottoRank(val matchCount: Int, val requiresBonusNumber: Boolean, val prizeAmount: LottoAmount) {
    FIRST(6, false, LottoAmount(2_000_000_000)),
    SECOND(5, true, LottoAmount(30_000_000)),
    THIRD(5, false, LottoAmount(1_500_000)),
    FORTH(4, false, LottoAmount(50_000)),
    FIFTH(3, false, LottoAmount(5_000)),
    UNRANKED(-1, false, LottoAmount(0)),
    ;

    companion object {
        fun determineRank(
            matchCount: Int,
            containsBonusNumber: Boolean,
        ): LottoRank {
            if (matchCount == 5 && containsBonusNumber) {
                return SECOND
            }

            return entries.filter { rank -> rank.requiresBonusNumber.not() }
                .find { rank -> rank.matchCount == matchCount }
                ?: UNRANKED
        }
    }
}
