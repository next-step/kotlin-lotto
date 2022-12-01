package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val reward: Long
) {
    MISS(0, 0L),
    FIFTH_PLACE(3, 5_000L),
    FOURTH_PLACE(4, 50_000L),
    THIRD_PLACE(5, 1_500_000L),
    SECOND_PLACE(5, 30_000_000L),
    FIRST_PLACE(6, 2_000_000_000L);

    companion object {
        private const val CHECK_MATCH_COUNT = 5

        fun valueOf(matchCount: Int, isBonus: Boolean): LottoRank =
            values().find {
                checkLottoRank(it, matchCount, isBonus)
            } ?: MISS

        fun getMissing(lottoRankList: Set<LottoRank>): Set<LottoRank> =
            values().toMutableSet()
                .minus(lottoRankList)

        private fun checkLottoRank(lottoRank: LottoRank, matchCount: Int, isBonus: Boolean): Boolean =
            if (matchCount == CHECK_MATCH_COUNT && isBonus) {
                lottoRank == SECOND_PLACE
            } else lottoRank.matchCount == matchCount
    }
}
