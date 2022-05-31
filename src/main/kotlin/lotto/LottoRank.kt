package lotto

enum class LottoRank(val matchCount: Int, val price: Long) {
    SIX_MATCH(6, 2_000_000_000L),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000L),
    FIVE_MATCH(5, 1_500_000L),
    FOUR_MATCH(4, 50_000L),
    THREE_MATCH(3, 5_000L),
    LOSE(0, 0);

    companion object {
        fun selectRank(matchCount: Int, matchBonus: Boolean): LottoRank = when {
            matchCount == 5 && matchBonus -> FIVE_MATCH_WITH_BONUS
            matchCount == 5 && !matchBonus -> FIVE_MATCH
            else -> values()
                .filter { it.matchCount != 5 }
                .find { it.matchCount == matchCount } ?: LOSE
        }
    }
}
