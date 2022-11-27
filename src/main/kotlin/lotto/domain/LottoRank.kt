package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val reward: Long,
    val isBonus: Boolean
) {
    FIFTH_PLACE(3, 5_000L, false),
    FOURTH_PLACE(4, 50_000L, false),
    THIRD_PLACE(5, 1_500_000L, false),
    SECOND_PLACE(5, 30_000_000L, true),
    FIRST_PLACE(6, 2_000_000_000L, false);

    companion object {
        private const val CHECK_MATCH_COUNT = 5

        fun valueOf(matchCount: Int, isBonus: Boolean): LottoRank? =
            values().find {
                checkLottoRank(it, matchCount, isBonus)
            }

        fun getMissing(lottoRankList: Set<LottoRank>): Set<LottoRank> =
            values().toMutableSet()
                .minus(lottoRankList)

        private fun checkLottoRank(lottoRank: LottoRank, matchCount: Int, isBonus: Boolean): Boolean =
            if (matchCount == CHECK_MATCH_COUNT) lottoRank.matchCount == matchCount && lottoRank.isBonus == isBonus
            else lottoRank.matchCount == matchCount
    }
}
