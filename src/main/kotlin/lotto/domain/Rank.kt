package lotto.domain

enum class Rank(val countOfMatch: Int, val prizeMoney: Int, val bonusMatch: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun valueOf(countOfMatch: Int, bonusMatch: Boolean): Rank {
            return values().find { rank ->
                rank.countOfMatch == countOfMatch && rank.bonusMatch == bonusMatch
            } ?: Rank.MISS
        }
    }
}

