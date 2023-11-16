package lotto

enum class LottoRanking(val matchingCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(matchingCount: Int): LottoRanking {
            return values().firstOrNull { it.matchingCount == matchingCount }
                ?: MISS
        }
    }
}

