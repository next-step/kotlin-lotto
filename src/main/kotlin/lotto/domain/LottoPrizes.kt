package lotto.domain

enum class LottoPrizes(
    val equalCount: Int,
    val money: Int,
    val catchBonus: Boolean = false
) {
    NONE(0, 0),
    MATCH_THREE_PRIZES(3, 5_000),
    MATCH_FOUR_PRIZES(4, 50_000),
    MATCH_FIVE_PRIZES(5, 1_500_000),
    MATCH_FIVE_PRIZES_WITH_BONUS(5, 30_000_000, true),
    MATCH_SIX_PRIZES(6, 2_000_000_000);

    companion object {
        fun of(equalCount: Int, catchBonus: Boolean): LottoPrizes {
            if (equalCount == MATCH_FIVE_PRIZES_WITH_BONUS.equalCount && catchBonus) {
                return MATCH_FIVE_PRIZES_WITH_BONUS
            }

            return LottoPrizes.values()
                .find { it.equalCount == equalCount }
                ?: NONE
        }
    }
}
