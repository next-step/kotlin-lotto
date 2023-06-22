package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val isBonusNumberMatch: Boolean = false,
    val winningMoney: Int,
    private val ignoreBonusNumberMatch: Boolean = true,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000, false),
    THIRD(5, false, 1_500_000, false),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    ;

    private fun isMatchCountSame(matchCount: Int): Boolean {
        return this.matchCount == matchCount
    }

    private fun isBonusNumberSame(isBonusNumberMatch: Boolean): Boolean {
        if (ignoreBonusNumberMatch) {
            return true
        }
        return this.isBonusNumberMatch == isBonusNumberMatch
    }

    private fun isMatch(matchCount: Int, isBonusNumberMatch: Boolean): Boolean {
        return isMatchCountSame(matchCount) && isBonusNumberSame(isBonusNumberMatch)
    }

    companion object {
        fun of(matchCount: Int, isBonusNumberMatch: Boolean): LottoRank? {
            return values().find { it.isMatch(matchCount, isBonusNumberMatch) }
        }

        fun createMapWithLottoRankAndZero(): MutableMap<LottoRank, Int> {
            return values().associateWith { 0 }.toMutableMap()
        }
    }
}
