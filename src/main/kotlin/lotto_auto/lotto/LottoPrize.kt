package lotto_auto.lotto

enum class LottoPrize(val winningAmount: Int) {
    NOTHING(0),
    FOURTH_PRIZE(5_000),
    THIRD_PRIZE(50_000),
    SECOND_PRIZE(1_500_000),
    FIRST_PRIZE(2_000_000_000);

    companion object {
        fun getLottoPrize(matchCount: Int): LottoPrize {
            return when (matchCount) {
                3 -> FOURTH_PRIZE
                4 -> THIRD_PRIZE
                5 -> SECOND_PRIZE
                6 -> FIRST_PRIZE
                else -> NOTHING
            }
        }
    }
}
