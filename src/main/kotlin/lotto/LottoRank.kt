package lotto

enum class LottoRank(val matchCount: Int, val price: Long, val isBonus: Boolean) {
    SIX_MATCH(6, 2_000_000_000L, false),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000L, true),
    FIVE_MATCH(5, 1_500_000L, false),
    FOUR_MATCH(4, 50_000L, false),
    THREE_MATCH(3, 5_000L, false),
    LOSE(0, 0, false);

    companion object {

        fun selectRank(matchCount: Int, matchBonus: Boolean): LottoRank {
            return values().find { it.matchCount == matchCount && it.isBonus == matchBonus } ?: LOSE
        }


    }
}
