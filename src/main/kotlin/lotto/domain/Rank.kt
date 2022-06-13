package lotto.domain

enum class Rank(val countOfMatch: Int, val prize: Double) {
    FIRST(6, 2_000_000_000.0),
    SECOND(5, 30_000_000.0),
    THIRD(5, 1_500_000.0),
    FOURTH(4, 50_000.0),
    FIFTH(3, 5_000.0),
    LOSE(0, 0.0);

    companion object {
        fun of(countOfMatch: Int, matchedBonus: Boolean): Rank {
            return if (matchedBonus) values().firstOrNull { it.countOfMatch == countOfMatch } ?: LOSE
            else values().lastOrNull { it.countOfMatch == countOfMatch } ?: LOSE
        }
    }
}
