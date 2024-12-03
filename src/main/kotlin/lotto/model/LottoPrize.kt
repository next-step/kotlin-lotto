package lotto.model

enum class LottoPrize(val matchCount: Int, val prizeAmount: Int) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 150_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0),
    ;

    companion object {
        private val lottoPrizeMapByCount = entries.associateBy(LottoPrize::matchCount)
        private val lottoPrizes = entries.toTypedArray().sortedByDescending { it.matchCount }

        fun fromMatchCount(matchCount: Int): LottoPrize = lottoPrizeMapByCount[matchCount] ?: NONE

        fun getLottoPrizes(): List<LottoPrize> = lottoPrizes
    }
}
