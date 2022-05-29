package lotto.domain

import lotto.vo.Money

enum class LottoRank(
    val matchCounts: List<Int>,
    val winningAmount: Money,
) {
    FIRST(matchCounts = listOf(6), winningAmount = Money.of(2_000_000_000)),
    SECOND(matchCounts = listOf(5), winningAmount = Money.of(30_000_000)),
    THIRD(matchCounts = listOf(5), winningAmount = Money.of(1_500_000)),
    FOURTH(matchCounts = listOf(4), winningAmount = Money.of(50_000)),
    FIFTH(matchCounts = listOf(3), winningAmount = Money.of(5_000)),
    NOTHING(matchCounts = listOf(2, 1, 0), winningAmount = Money.of(0));

    companion object {
        private val MATCH_COUNT_RANGE = 0..6

        fun of(matchCount: Int, bonusMatch: Boolean): LottoRank {
            require(matchCount in MATCH_COUNT_RANGE) {
                "로또 일치 개수는 ${MATCH_COUNT_RANGE.first} 와 ${MATCH_COUNT_RANGE.last} 사이여야 합니다. (입력:$matchCount)"
            }

            if (SECOND.matchCounts.contains(matchCount) && bonusMatch) {
                return SECOND
            }

            return values().filterNot { it == SECOND }
                .find { it.matchCounts.contains(matchCount) }
                ?: NOTHING
        }
    }
}
