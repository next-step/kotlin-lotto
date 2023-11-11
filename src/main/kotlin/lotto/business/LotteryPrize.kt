package lotto.business

enum class LotteryPrize(private val matchCount: Int, val prizeAmount: Long) {
    MISS(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_500_000L),
    FIRST(6, 2_000_000_000L);

    companion object {
        fun getPrize(matchCount: Int, contains: Boolean): LotteryPrize =
            if (matchCount == THIRD.matchCount && contains) SECOND
            else values().find { it.matchCount == matchCount } ?: MISS
    }
}
