package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val price: Int,
) {

    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    BONUS_SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun getRank(lottoMatchCount: LottoMatchCount): LottoRank {
            val rank = values().firstOrNull { it.matchCount == lottoMatchCount.matchCount } ?: NONE
            if (rank.matchCount != 5) {
                return rank
            }

            return checkBonusNumber(rank, lottoMatchCount)
        }

        private fun checkBonusNumber(rank: LottoRank, lottoMatchCount: LottoMatchCount): LottoRank {
            if (lottoMatchCount.containsBonusNumber) {
                return BONUS_SECOND
            }

            return rank
        }
    }
}
