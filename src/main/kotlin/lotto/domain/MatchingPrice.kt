package lotto.domain

enum class MatchPrize(val matchCount: Int, val prize: Long) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 20_000_000_000);

    companion object {
        private val matchCountMap = entries.associateBy { it.matchCount }

        fun prizeFor(count: Int): Long? = matchCountMap[count]?.prize
    }
}
