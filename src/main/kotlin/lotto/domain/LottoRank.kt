package lotto.domain

enum class LottoRank(val matchCount: Int, val winningMoney: Int, val matchBonus: Boolean) {
    FIRST_PLACE(matchCount = 6, winningMoney = 2_000_000_000, matchBonus = false),
    SECOND_PLACE(matchCount = 5, winningMoney = 30_000_000, matchBonus = true),
    THIRD_PLACE(matchCount = 5, winningMoney = 1_500_000, matchBonus = false),
    FORTH_PLACE(matchCount = 4, winningMoney = 50_000, matchBonus = false),
    FIFTH_PLACE(matchCount = 3, winningMoney = 5_000, matchBonus = false),
    NOT_PLACE(matchCount = 0, winningMoney = 0, matchBonus = false);

    companion object {
        private const val SECOND_OR_THIRD_PLACE_MATCH_COUNT = 5

        fun valuesExcludeNotPlace(): List<LottoRank> {
            return values().filter { it != NOT_PLACE }
        }

        private fun isSecondOrThirdPlaceMatchCount(matchCount: Int): Boolean = matchCount == SECOND_OR_THIRD_PLACE_MATCH_COUNT

        fun selectByMatchCount(matchCount: Int, matchBonus: Boolean): LottoRank {
            if (isSecondOrThirdPlaceMatchCount(matchCount)) {
                return values().find { it.matchCount == matchCount && it.matchBonus == matchBonus } ?: NOT_PLACE
            }
            return values().find { it.matchCount == matchCount } ?: NOT_PLACE
        }
    }
}
