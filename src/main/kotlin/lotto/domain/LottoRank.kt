package lotto.domain

enum class LottoRank(val matchCount: Int, val winningAmount: Int) {
    NONE(0, 0),
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoRank = when {
            matchCount == 6 -> FIRST
            matchCount == 5 && matchBonus -> SECOND
            matchCount == 5 -> THIRD
            matchCount == 4 -> FOURTH
            matchCount == 3 -> FIFTH
            else -> NONE
        }
    }
}
