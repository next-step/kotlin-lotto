package camp.nextstep.lotto.raffle

enum class Winnings(val matchedCount: Int, val winnings: Int) {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000);

    companion object {

        private val countMap = mapOf(
            THREE.matchedCount to THREE,
            FOUR.matchedCount to FOUR,
            FIVE.matchedCount to FIVE,
            SIX.matchedCount to SIX
        )

        fun of(matchedCount: Int) = requireNotNull(countMap[matchedCount])
    }
}
