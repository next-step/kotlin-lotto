package lotto.domain

enum class Rank(val countOfMatch: Int, val prizeMoney: Int, val matchWithBonus: Boolean = false) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    companion object {
        fun getRank(countOfMatch: Int, matchWithBonus: Boolean = false): Rank {
            return values().find { it.countOfMatch == countOfMatch }!!
        }
    }
}
