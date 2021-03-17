package lotto.domain

enum class Rank(val count: Int, val amount: Int) {
    FAIL(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun getRankByCount(count: Int): Rank {
            return values().firstOrNull { it.count == count } ?: FAIL
        }

        fun getWonRank(): List<Rank> {
            return listOf(FIFTH, FOURTH, THIRD, FIRST)
        }
    }
}
