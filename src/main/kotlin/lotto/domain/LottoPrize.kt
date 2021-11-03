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

        fun valueOf(countOfMatch: Int, matchBonus: Boolean): LottoPrize {
            return values().find {
                if (countOfMatch == 5 && matchBonus) {
                    return SECOND
                } else if (countOfMatch == 5 && !matchBonus) {
                    return THIRD
                } else {
                    it.matchingNumberCount == countOfMatch
                }
            } ?: MISS
        }
    }
}
