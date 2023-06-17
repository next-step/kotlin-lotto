package lotto.domain

enum class LottoPrizes(
    val equalCount: Int,
    val money: Int
) {
    MATCH_THREE_PRIZES(3, 5_000),
    MATCH_FOUR_PRIZES(4, 50_000),
    MATCH_FIVE_PRIZES(5, 1_500_000),
    MATCH_SIX_PRIZES(6, 2_000_000_000);

    companion object {
        private const val DEFAULT_MONEY: Int = 0

        fun getMoney(equalCount: Int): Int {
            val money = LottoPrizes.values().find { it.equalCount == equalCount }?.money
            return money ?: DEFAULT_MONEY
        }
    }
}
