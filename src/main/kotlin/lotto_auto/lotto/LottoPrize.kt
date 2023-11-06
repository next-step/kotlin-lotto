package lotto_auto.lotto

enum class LottoPrize(val matchCount: Int, val winningAmount: Int) {
    MISS(0, 0),
    FIFTH_PRIZE(3, 5_000),
    FOURTH_PRIZE(4, 50_000),
    THIRD_PRIZE(5, 1_500_000),
    SECOND_PRIZE(5, 30_000_000),
    FIRST_PRIZE(6, 2_000_000_000);

    companion object {
        fun getLottoPrize(matchCount: Int, matchBonus: Boolean): LottoPrize {
            return values().find { lottoPrize ->
                lottoPrize.matchCount == matchCount
            }?.let {
                valueOfLottoPrize(it, matchBonus)
            } ?: MISS
        }

        private fun valueOfLottoPrize(it: LottoPrize, matchBonus: Boolean): LottoPrize {
            return if (it.matchCount == 5) {
                findPrizeWithMatchBonus(matchBonus)
            } else {
                it
            }
        }

        private fun findPrizeWithMatchBonus(matchBonus: Boolean): LottoPrize {
            return if (matchBonus) SECOND_PRIZE else THIRD_PRIZE
        }
    }
}
