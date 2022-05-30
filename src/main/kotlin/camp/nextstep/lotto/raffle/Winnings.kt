package camp.nextstep.lotto.raffle

enum class Winnings(val matchedCount: Int, val winnings: Int, val matchedBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    companion object {

        private val WINNINGS_MATCH_COUNTS = 3..6

        private val COUNT_WINNINGS_MAP = mapOf(
            FIFTH.matchedCount to FIFTH,
            FOURTH.matchedCount to FOURTH,
            THIRD.matchedCount to THIRD,
            FIRST.matchedCount to FIRST
        )

        fun of(matchedCount: Int, matchedBonus: Boolean = false): Winnings {
            if (matchedBonus && matchedCount == 5) return SECOND
            return requireNotNull(COUNT_WINNINGS_MAP[matchedCount])
        }

        fun isWinningCount(matchedCount: Int) = matchedCount in WINNINGS_MATCH_COUNTS
    }
}
