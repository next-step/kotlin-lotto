package lotto.domain

enum class Rank(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ELSE(0, 0);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): Rank {
            var rank = values().firstOrNull { it.matchCount == matchCount } ?: ELSE
            if (rank == SECOND &&
                !matchBonus
            ) {
                rank = THIRD
            }
            return rank
        }
    }
}
