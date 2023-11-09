package lotto.domain

enum class LottoPrize(val matchingCount: Int, value: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    val amount: Amount = Amount(value)

    companion object {
        val WINNING_RANK = values().filter { it != MISS }

        fun from(matchingCount: Int, matchBonus: Boolean): LottoPrize {
            return values().find {
                if (it == SECOND) {
                    return@find it.matchingCount == matchingCount && matchBonus
                }

                it.matchingCount == matchingCount
            } ?: MISS
        }
    }
}
