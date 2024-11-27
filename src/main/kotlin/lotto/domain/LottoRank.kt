package lotto.domain

enum class LottoRank(
    val rank: Int,
    val prize: Int,
    val matchCount: Int,
    val isBonusRequired: Boolean = false,
) {
    FIRST(1, 2_000_000_000, 6) {
        override fun matches(
            matchCount: Int,
            bonusMatch: Boolean,
        ): Boolean {
            return this.matchCount == matchCount
        }
    },
    SECOND(2, 30_000_000, 5, true) {
        override fun matches(
            matchCount: Int,
            bonusMatch: Boolean,
        ): Boolean {
            return this.matchCount == matchCount && bonusMatch
        }
    },
    THIRD(3, 1_500_000, 5) {
        override fun matches(
            matchCount: Int,
            bonusMatch: Boolean,
        ): Boolean {
            return this.matchCount == matchCount && !bonusMatch
        }
    },
    FOURTH(4, 50_000, 4) {
        override fun matches(
            matchCount: Int,
            bonusMatch: Boolean,
        ): Boolean {
            return this.matchCount == matchCount
        }
    },
    FIFTH(5, 5_000, 3) {
        override fun matches(
            matchCount: Int,
            bonusMatch: Boolean,
        ): Boolean {
            return this.matchCount == matchCount
        }
    },
    NO_RANK(6, 0, 0) {
        override fun matches(
            matchCount: Int,
            bonusMatch: Boolean,
        ): Boolean {
            return this.matchCount == 0
        }
    }, ;

    abstract fun matches(
        matchCount: Int,
        bonusMatch: Boolean,
    ): Boolean

    companion object {
        fun fromMatchAndBonus(
            matchCount: Int,
            bonusMatch: Boolean,
        ): LottoRank {
            return entries.firstOrNull { it.matches(matchCount, bonusMatch) } ?: NO_RANK
        }
    }
}
