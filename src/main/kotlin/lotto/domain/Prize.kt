package lotto.domain

enum class Prize(val countOfMatch: Int, private val rank: Int, val prizeMoney: Int, var count: Int = 0) {
    MATCH_NONE(0, 0, 0),
    MATCH_ONE(1, 0, 0),
    MATCH_TWO(2, 0, 0),
    MATCH_THREE(3, 5, 5_000),
    MATCH_FOUR(4, 4, 50_000),
    MATCH_FIVE(5, 3, 1_500_000),
    MATCH_ALL(6, 1, 2_000_000_000);

    fun addCount() {
        count++
    }

    companion object {
        fun getPrizeMoney(countOfMatch: Int): Int {
            return values().find { it.countOfMatch == countOfMatch }?.prizeMoney ?: 0
        }

        fun getPrize(countOfMatch: Int): Prize {
            return values().find { it.countOfMatch == countOfMatch }!!
        }
    }
}
