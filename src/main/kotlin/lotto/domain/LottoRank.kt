package lotto.domain

enum class LottoRank(val matchCount: Int, val prize: Int, val isBonusMatched: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000, true),
    THIRD(5, 30_000_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun getRank(matchCount: Int, isBonusMatched: Boolean): LottoRank =
            values().firstOrNull { it.matchCount == matchCount && (!it.isBonusMatched || isBonusMatched) }
                ?: MISS
    }
}
