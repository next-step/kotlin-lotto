package lotto.domain

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun of(matchCount: Int): LottoPrize {
            return when (matchCount) {
                FIRST.matchCount -> FIRST
                SECOND.matchCount -> SECOND
                THIRD.matchCount -> THIRD
                FOURTH.matchCount -> FOURTH
                else -> MISS
            }
        }
    }
}
