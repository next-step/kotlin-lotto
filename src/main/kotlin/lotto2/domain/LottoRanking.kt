package lotto2.domain

enum class LottoRanking(val matchingCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(matchingCount: Int, isBonusMatched: Boolean = false): LottoRanking {
            if (SECOND.matchingCount == matchingCount && isBonusMatched) {
                return SECOND
            }

            if (THIRD.matchingCount == matchingCount && !isBonusMatched) {
                return THIRD
            }

            return values().find {
                it.matchingCount == matchingCount
            } ?: MISS
        }
    }
}
