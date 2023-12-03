package lotto

enum class LottoRanking(val matchingCount: Int, val isBonusMatched: Boolean, val prize: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0),
    ;

    companion object {
        fun valueOf(matchingCount: Int, isBonusMatched: Boolean = false): LottoRanking {
            return when {
                matchingCount == 6 -> FIRST
                matchingCount == 5 && isBonusMatched -> SECOND
                matchingCount == 5 -> THIRD
                matchingCount == 4 -> FOURTH
                matchingCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}
