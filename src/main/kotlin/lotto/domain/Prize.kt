package lotto.domain

enum class Prize(val countOfMatch: Int, private val rank: Int, val prizeMoney: Int) {
    MATCH_NONE(0, 0, 0),
    MATCH_ONE(1, 0, 0),
    MATCH_TWO(2, 0, 0),
    MATCH_THREE(3, 5, 5_000),
    MATCH_FOUR(4, 4, 50_000),
    MATCH_FIVE(5, 3, 1_500_000),
    MATCH_FIVE_WITH_BONUS(5, 2, 30_000_000),
    MATCH_ALL(6, 1, 2_000_000_000);

    companion object {
        fun getPrize(countOfMatch: Int): Prize {
            return values().find { it.countOfMatch == countOfMatch }!!
        }
    }
}
