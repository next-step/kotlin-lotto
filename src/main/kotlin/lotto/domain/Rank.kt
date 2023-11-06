package lotto.domain

enum class Rank(val matchCount: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    OUT_OF_RANK(-1, 0)
    ;

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): Rank {
            if (matchCount == SECOND.matchCount && matchBonus) {
                return SECOND
            }
            return when (matchCount) {
                FIRST.matchCount -> FIRST
                THIRD.matchCount -> THIRD
                FOURTH.matchCount -> FOURTH
                FIFTH.matchCount -> FIFTH
                else -> OUT_OF_RANK
            }
        }
    }
}

