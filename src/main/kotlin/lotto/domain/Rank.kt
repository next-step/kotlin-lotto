package lotto.domain

enum class Rank(val countOfMatch: Int, val matchedBonus: Boolean = false, val prize: Double) {
    FIRST(countOfMatch = 6, prize = 2_000_000_000.0),
    SECOND(countOfMatch = 5, matchedBonus = true, prize = 30_000_000.0),
    THIRD(countOfMatch = 5, prize = 1_500_000.0),
    FOURTH(countOfMatch = 4, prize = 50_000.0),
    FIFTH(countOfMatch = 3, prize = 5_000.0),
    LOSE(countOfMatch = 0, prize = 0.0)
    ;

    companion object {
        fun of(countOfMatch: Int, matchedBonus: Boolean): Rank {
            return when (matchedBonus) {
                true -> values().firstOrNull { it.countOfMatch == countOfMatch } ?: LOSE
                false -> values().lastOrNull { it.countOfMatch == countOfMatch } ?: LOSE
            }
        }
    }
}
