package lotto.domain

enum class Prize(val countOfMatch: Int, private val rank: Int, val prizeMoney: Int, val withBonus: Boolean = false) {
    MATCH_THREE(3, 5, 5_000),
    MATCH_FOUR(4, 4, 50_000),
    MATCH_FIVE(5, 3, 1_500_000),
    MATCH_FIVE_WITH_BONUS(5, 2, 30_000_000, true),
    MATCH_ALL(6, 1, 2_000_000_000),
    MISS(0, 0, 0);

    companion object {
        fun getPrize(countOfMatch: Int): Prize {
            if (countOfMatch < MATCH_THREE.countOfMatch) return MISS
            return values().find { it.countOfMatch == countOfMatch }!!
        }
    }
}
