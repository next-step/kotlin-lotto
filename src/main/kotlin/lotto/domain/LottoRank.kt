package lotto.domain

enum class LottoRank(val matchCount: Int, val winningMoney: Int, val matchBonus: Boolean) {
    FIRST_PLACE(matchCount = 6, winningMoney = 2_000_000_000, matchBonus = false),
    SECOND_PLACE(matchCount = LottoRank.SECOND_OR_THIRD_PLACE_MATCH_COUNT, winningMoney = 30_000_000, matchBonus = true),
    THIRD_PLACE(matchCount = LottoRank.SECOND_OR_THIRD_PLACE_MATCH_COUNT, winningMoney = 1_500_000, matchBonus = false),
    FORTH_PLACE(matchCount = 4, winningMoney = 50_000, matchBonus = false),
    FIFTH_PLACE(matchCount = 3, winningMoney = 5_000, matchBonus = false);

    companion object {
        private const val SECOND_OR_THIRD_PLACE_MATCH_COUNT = 5

        fun selectByMatchCount(matchCount: Int, matchBonus: Boolean): LottoRank? {
            if (matchCount == SECOND_OR_THIRD_PLACE_MATCH_COUNT) {
                return values().find { it.matchCount == matchCount && it.matchBonus == matchBonus }
            }
            return values().find { it.matchCount == matchCount }
        }
    }
}
