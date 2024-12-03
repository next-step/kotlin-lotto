package lotto.domain

enum class LottoRank(val matchCount: Int, val prizeAmount: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    ;

    companion object {
        private val VALID_MATCH_COUNT = entries.map { rank -> rank.matchCount }

        fun from(matchCount: Int): LottoRank {
            return entries.find { rank -> rank.matchCount == matchCount }
                ?: throw InvalidMatchCountException(matchCount)
        }

        fun isInTheRank(matchCount: Int): Boolean {
            return VALID_MATCH_COUNT.contains(matchCount)
        }
    }
}
