package lotto.domain

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun of(matchCount: Int, hasBonus: Boolean): LottoPrize {
            return when (matchCount) {
                FIRST.matchCount -> FIRST
                SECOND.matchCount -> if (hasBonus) SECOND else THIRD
                FOURTH.matchCount -> FOURTH
                FIFTH.matchCount -> FIFTH
                else -> MISS
            }
        }
    }
}
