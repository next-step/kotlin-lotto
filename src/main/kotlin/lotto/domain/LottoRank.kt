package lotto.domain

enum class LottoRank(val price: Int, val matchingCount: Int, val bonusMatchRequired: Boolean = false) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 2) {
        override fun isMatch(count: Int): Boolean = count <= matchingCount
    };

    open fun isMatch(count: Int): Boolean =
        this.matchingCount == count

    companion object {
        fun of(matchingCount: Int, isBonusMatch: Boolean): LottoRank {
            return values()
                .filter { if (it.bonusMatchRequired) isBonusMatch else true }
                .first { it.isMatch(matchingCount) }
        }
    }
}
