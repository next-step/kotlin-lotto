package lotto.entity

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun find(countOfMatch: Int): Rank {
            return Rank.values().find { it -> (it.countOfMatch == countOfMatch) } ?: MISS
        }
    }
}
