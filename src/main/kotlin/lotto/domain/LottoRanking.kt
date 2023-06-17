package lotto.domain

enum class LottoRanking(val matchCount: Int, val winningAmount: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(matchCount: Int, matchBonus: Boolean): LottoRanking = when {
            FIRST.matchCount == matchCount -> FIRST
            SECOND.matchCount == matchCount && matchBonus -> SECOND
            THIRD.matchCount == matchCount && !matchBonus -> THIRD
            FOURTH.matchCount == matchCount -> FOURTH
            FIFTH.matchCount == matchCount -> FIFTH
            else -> MISS
        }
    }
}
