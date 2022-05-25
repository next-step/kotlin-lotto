package camp.nextstep.lotto.raffle

enum class Winnings(val matchedCount: Int, val winnings: Int) {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000);

    companion object {

        private val WINNINGS_MATCH_COUNTS = 3..6

        private val COUNT_WINNINGS_MAP = mapOf(
            THREE.matchedCount to THREE,
            FOUR.matchedCount to FOUR,
            FIVE.matchedCount to FIVE,
            SIX.matchedCount to SIX
        )

        fun of(matchedCount: Int) = requireNotNull(COUNT_WINNINGS_MAP[matchedCount])

        fun isWinningCount(matchedCount: Int) = matchedCount in WINNINGS_MATCH_COUNTS
    }
}
