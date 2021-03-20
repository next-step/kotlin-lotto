package lotto.domain.result

enum class LottoRank(val matchCount: Int, val prize: Long) {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    NONE(0, 0L);

    companion object {
        private val matcher = mapOf(Pair(FIRST, 0), Pair(SECOND, 0), Pair(THIRD, 0), Pair(FOURTH, 0), Pair(NONE, 0))

        private fun of(matchCount: Int): LottoRank {
            return values().find { matchCount == it.matchCount } ?: NONE
        }

        fun rank(matchInfos: List<MatchInfo>): LottoResult {
            val result = matcher.toMutableMap()
            matchInfos.forEach { result[of(it.matchCount)] = result[of(it.matchCount)]!! + 1 }
            return LottoResult(result)
        }
    }
}
