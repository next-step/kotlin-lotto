package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val isBonusNumberMatch: Boolean = false,
    val winningMoney: Int,
) {
    FIRST(6, false, 2_000_000_000) {
        override fun isMatch(matchCount: Int, isBonusNumberMatch: Boolean): Boolean {
            return isMatchCountSame(matchCount)
        }
    },
    SECOND(5, true, 30_000_000) {
        override fun isMatch(matchCount: Int, isBonusNumberMatch: Boolean): Boolean {
            return isMatchCountSame(matchCount) && isBonusNumberSame(isBonusNumberMatch)
        }
    },
    THIRD(5, false, 1_500_000) {
        override fun isMatch(matchCount: Int, isBonusNumberMatch: Boolean): Boolean {
            return isMatchCountSame(matchCount) && isBonusNumberSame(isBonusNumberMatch)
        }
    },
    FOURTH(4, false, 50_000) {
        override fun isMatch(matchCount: Int, isBonusNumberMatch: Boolean): Boolean {
            return isMatchCountSame(matchCount)
        }
    },
    FIFTH(3, false, 5_000) {
        override fun isMatch(matchCount: Int, isBonusNumberMatch: Boolean): Boolean {
            return isMatchCountSame(matchCount)
        }
    },
    ;
    protected abstract fun isMatch(matchCount: Int, isBonusNumberMatch: Boolean): Boolean

    protected fun isMatchCountSame(matchCount: Int): Boolean {
        return this.matchCount == matchCount
    }

    protected fun isBonusNumberSame(isBonusNumberMatch: Boolean): Boolean {
        return this.isBonusNumberMatch == isBonusNumberMatch
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
