package lotto.domain

import lotto.vo.Money

enum class LottoRank(
    val matchCounts: List<LottoMatchCount>,
    val winningAmount: Money
) {
    FIRST(LottoMatchCount.listOf(6), Money.of(2_000_000_000)),
    SECOND(LottoMatchCount.listOf(5), Money.of(1_500_000)),
    THIRD(LottoMatchCount.listOf(4), Money.of(50_000)),
    FOURTH(LottoMatchCount.listOf(3), Money.of(5_000)),
    NOTHING(LottoMatchCount.listOf(2, 1, 0), Money.of(0));

    companion object {
        fun of(matchCount: LottoMatchCount): LottoRank {
            return values().find { it.matchCounts.contains(matchCount) }
                ?: NOTHING
        }
    }
}
