package lotto.domain

enum class LottoPrizes(
    val equalCount: Int,
    val money: Int
) {
    MATCH_THREE_PRIZES(3, 5000),
    MATCH_FOUR_PRIZES(4, 50000),
    MATCH_FIVE_PRIZES(5, 1500000),
    MATCH_SIX_PRIZES(6, 2000000000);

    companion object {
        fun getMoney(equalCount: Int): Int {
            val money = LottoPrizes.values().find { it.equalCount == equalCount }?.money
            return money ?: 0
        }
    }
}
