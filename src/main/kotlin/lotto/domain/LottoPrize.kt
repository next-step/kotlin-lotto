package lotto.domain

enum class LottoPrize(val value: Int, val price: Int) {
    SIX_MATCH(6, 2_000_000_000),
    FIVE_BONUS_MATCH(5, 30_000_000),
    FIVE_MATCH(5, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(3, 5_000),
    NOT_MATCH(0, 0);

    companion object {
        fun from(value: Int, matchBonus: Boolean): LottoPrize {
            if (value == FIVE_MATCH.value && matchBonus) {
                return FIVE_BONUS_MATCH
            }
            if (value == FIVE_MATCH.value && !matchBonus) {
                return FIVE_MATCH
            }
            return values().find { it.value == value } ?: NOT_MATCH
        }
    }
}
