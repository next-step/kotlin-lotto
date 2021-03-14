package lotto.domain.result

enum class LottoRank(private val matchCount: Int, private val prize: Long) {
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

        fun rank(matchCounts: List<Int>): LottoResult {
            val result = matcher.toMutableMap()
            matchCounts.forEach { result[of(it)] = result[of(it)]!! + 1 }
            return LottoResult(result)
        }
    }
}
