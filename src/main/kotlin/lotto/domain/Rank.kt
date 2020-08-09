package lotto.domain

enum class Rank(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    ELSE(0, 0);

    companion object {
        fun of(matchCount: Int): Rank {
            return values().find { it.matchCount == matchCount } ?: ELSE
        }
    }
}
