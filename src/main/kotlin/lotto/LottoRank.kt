package lotto

enum class LottoRank(private val matchCount: Int, private val prizeAmount: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000), ;

    companion object {
        fun from(matchCount: Int): LottoRank {
            return entries.find { rank -> rank.matchCount == matchCount }
                ?: throw InvalidMatchCountException(matchCount)
        }

        fun isInTheRank(matchCount: Int): Boolean {
            return matchCount >= FORTH.matchCount
        }
    }
}
