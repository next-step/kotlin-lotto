package lotto.business

enum class LotteryPrize(private val matchCount: Int, private val prizeAmount: Long) {
    NONE(0, 0L),
    THREE_MATCH(3, 5_000L),
    FOUR_MATCH(4, 50_000L),
    FIVE_MATCH(5, 1_500_000L),
    SIX_MATCH(6, 2_000_000_000L);

    companion object {
        fun getPrize(matchCount: Int): LotteryPrize {
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
