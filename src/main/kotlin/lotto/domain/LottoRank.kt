package lotto.domain

import lotto.vo.Money

enum class LottoRank(
    val matchCounts: List<Int>,
    val winningAmount: Money
) {
    FIRST(listOf(6), Money.of(2_000_000_000)),
    SECOND(listOf(5), Money.of(1_500_000)),
    THIRD(listOf(4), Money.of(50_000)),
    FOURTH(listOf(3), Money.of(5_000)),
    NOTHING(listOf(2, 1, 0), Money.of(0));

    companion object {
        private const val MIN_MATCH_COUNT = 0
        private const val MAX_MATCH_COUNT = 6

        fun of(matchCount: Int): LottoRank {
            validateMatchCount(matchCount)
            return values().find { it.matchCounts.contains(matchCount) }
                ?: NOTHING
        }

        private fun validateMatchCount(matchCount: Int) {
            if (matchCount < MIN_MATCH_COUNT || matchCount > MAX_MATCH_COUNT) {
                throw IllegalArgumentException(
                    "로또 일치 개수는 $MIN_MATCH_COUNT 와 $MAX_MATCH_COUNT 사이여야 합니다. (입력:$matchCount)"
                )
            }
        }
    }
}
