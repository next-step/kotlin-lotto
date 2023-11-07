package lotto_auto.lotto

enum class LottoPrize(val matchCount: Int, val winningAmount: Int) {
    MISS(0, 0),
    FOURTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000);

    companion object {
        fun getLottoPrize(matchCount: Int): LottoPrize {
            return values().find { lottoPrize ->
                lottoPrize.matchCount == matchCount
            } ?: MISS
        }
    }
}
