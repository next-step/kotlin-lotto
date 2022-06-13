package lotto.domain

enum class Rank(val countOfMatch: Int, val matchedBonus: Boolean, val prize: Double) {
    FIRST(6, false, 2_000_000_000.0),
    SECOND(5, true, 30_000_000.0),
    THIRD(5, false, 1_500_000.0),
    FOURTH(4, false, 50_000.0),
    FIFTH(3, false, 5_000.0),
    LOSE(0, false, 0.0);

    companion object {
        fun of(countOfMatch: Int, matchedBonus: Boolean): Rank {
            return values().firstOrNull { it.countOfMatch == countOfMatch && it.matchedBonus == matchedBonus } ?: LOSE
        }
    }
}
