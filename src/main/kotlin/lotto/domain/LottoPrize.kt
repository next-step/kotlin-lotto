package lotto.domain

enum class LottoPrize(val matchingNumberCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun getPrizes() = values().toList()

        fun valueOf(countOfMatch: Int, matchBonus: Boolean): LottoPrize =
            when (countOfMatch) {
                FIRST.matchingNumberCount -> FIRST
                THIRD.matchingNumberCount -> if (matchBonus) SECOND else THIRD
                FOURTH.matchingNumberCount -> FOURTH
                FIFTH.matchingNumberCount -> FIFTH
                else -> MISS
            }
    }
}
