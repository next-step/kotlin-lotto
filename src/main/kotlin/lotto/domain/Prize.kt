package lotto.domain

enum class Prize(val countOfMatch: Int, private val rank: Int, val prizeMoney: Int) {
    MATCH_NONE(0, 0, 0),
    MATCH_ONE(1, 0, 0),
    MATCH_TWO(2, 0, 0),
    MATCH_THREE(3, 5, 5000),
    MATCH_FOUR(4, 4, 50000),
    MATCH_FIVE(5, 3, 1500000),
    MATCH_ALL(6, 1, 2000000000);

    companion object {
        fun getPrizeMoney(countOfMatch: Int): Int {
            return values().find { it.countOfMatch == countOfMatch }?.prizeMoney ?: 0
        }
    }
}
