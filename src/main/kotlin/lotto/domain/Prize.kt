package lotto.domain

enum class Prize(val countOfMatch: Int, val prizeMoney: Int, val withBonus: Boolean = false) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    companion object {
        fun getPrize(countOfMatch: Int, isContainBonusNumber: Boolean = false): Prize {
            if (countOfMatch < FIFTH.countOfMatch) return MISS
            return values().find { it.countOfMatch == countOfMatch && it.withBonus == isContainBonusNumber } ?: MISS
        }
    }
}
