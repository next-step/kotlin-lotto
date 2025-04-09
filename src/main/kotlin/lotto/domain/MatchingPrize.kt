package lotto.domain

enum class MatchPrize(val matchCount: Int, val usingBonus: Boolean, val price: Long) {
    FIRST(6, false, 20_000_000_000),
    SECOND(5, true,30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    companion object {
        private val matchCountMap = entries.associateBy { Pair(it.matchCount, it.usingBonus) }

        fun prizeFor(count: Int, usingBonus: Boolean): MatchPrize? =
            matchCountMap[Pair(count, usingBonus)]
    }
}
