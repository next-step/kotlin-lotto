package lotto.domain

enum class LottoPrize(val matchingCount: Int, value: Int, val includeBonus: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    val amount: Amount = Amount(value)

    companion object {
        val WINNING_RANK = values().filter { it != MISS }

        fun from(matchingCount: Int, matchBonus: Boolean): LottoPrize {
            return values().find {
                if (it.includeBonus) {
                    return@find it.matchingCount == matchingCount && matchBonus
                }

                it.matchingCount == matchingCount
            } ?: MISS
        }
    }
}
