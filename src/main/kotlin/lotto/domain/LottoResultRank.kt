package lotto.domain

enum class LottoResultRank(val lottoResultRankKey: LottoResultRankKey, val prizeMoney: Long) {
    MISSED(LottoResultRankKey(MatchedCount.of(0)), 0L),
    FIFTH(LottoResultRankKey(MatchedCount.of(3)), 5_000L),
    FOURTH(LottoResultRankKey(MatchedCount.of(4)), 50_000L),
    THIRD(LottoResultRankKey(MatchedCount.of(5)), 1_500_000L),
    SECOND(LottoResultRankKey(MatchedCount.of(5), true), 3_000_000L),
    FIRST(LottoResultRankKey(MatchedCount.of(6)), 2_000_000_000L),
    ;

    companion object {
        private val rankMap = values().associateBy { it.lottoResultRankKey }

        fun getRank(matchedCount: MatchedCount, bonusNumberMatched: Boolean): LottoResultRank {
            return rankMap.getOrDefault(LottoResultRankKey(matchedCount, bonusNumberMatched), MISSED)
        }
    }
}
