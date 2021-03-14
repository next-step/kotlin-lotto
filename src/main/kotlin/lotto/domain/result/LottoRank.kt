package lotto.domain.result

enum class LottoRank(private val matchCount: Int, private val prize: Long) {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    NONE(0, 0L);

    companion object {
        private fun of(matchCount: Int): LottoRank {
            return values().find { matchCount == it.matchCount } ?: NONE
        }

        fun rank(matchCounts: List<Int>): List<LottoRank> {
            return matchCounts.map { of(it) }
        }
    }
}
