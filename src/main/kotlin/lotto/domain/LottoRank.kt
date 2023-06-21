package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val isBonusNumberMatch: Boolean = false,
    val winningMoney: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ;

    private fun isMatchCountSame(matchCount: Int): Boolean {
        return this.matchCount == matchCount
    }

    private fun isBonusNumberSame(isBonusNumberMatch: Boolean): Boolean {
        return this.isBonusNumberMatch == isBonusNumberMatch
    }

    companion object {
        private val MAP_BY_MATCH_COUNT = values().associateBy { it.matchCount }

        fun of(matchCount: Int, isBonusNumberMatch: Boolean): LottoRank? {
            if (SECOND.isMatchCountSame(matchCount) && SECOND.isBonusNumberSame(isBonusNumberMatch)) {
                return SECOND
            }
            return MAP_BY_MATCH_COUNT[matchCount]
        }

        fun createMapWithLottoRankAndZero(): MutableMap<LottoRank, Int> {
            return values().associateWith { 0 }.toMutableMap()
        }
    }
}
