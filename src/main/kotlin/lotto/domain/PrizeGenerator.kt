package lotto.domain

enum class PrizeGenerator(val matchCount: Int, val prize: Int) {

    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    BONUS_MATCH(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000),
    ZERO_MATCH(0, 0);

    var count: Int = 0

    fun countRank() {
        this.count++
    }

    companion object {

        fun findByMatch(matchCount: Int, isBonusNumberMatched: Boolean): PrizeGenerator {
            if (matchCount == FIVE_MATCH.matchCount) return when (isBonusNumberMatched) {
                true -> BONUS_MATCH
                false -> FIVE_MATCH
            }
            return values().find { it.matchCount == matchCount } ?: ZERO_MATCH
        }

        fun winningPrize() =
            (THREE_MATCH.count * THREE_MATCH.prize) + (FOUR_MATCH.count * FOUR_MATCH.prize) + (FIVE_MATCH.count * FIVE_MATCH.prize) + (BONUS_MATCH.count * BONUS_MATCH.prize) + (SIX_MATCH.count * SIX_MATCH.prize)
    }
}
