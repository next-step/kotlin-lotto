package next.step.lotto.domain

enum class LottoRank(val matchCount: Int, val winnings: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    fun shouldMatchBonus(): Boolean = this == SECOND

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): LottoRank {
            return when {
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 && !matchBonus -> THIRD
                else -> values().find { it.matchCount == matchCount } ?: MISS
            }
        }
    }
}
