package lotto.domain

import lotto.application.vo.Amount

enum class MatchType(val matchCount: Int, val amount: Amount) {
    NONE_MATCH(0, Amount(0)),
    THREE_MATCH(3, Amount(5_000)),
    FOUR_MATCH(4, Amount(50_000)),
    FIVE_MATCH(5, Amount(1_500_000)),
    SIX_MATCH(6, Amount(2_000_000_000));

    companion object {
        fun findMatchType(
            matchCount: Int
        ): MatchType = values().find { winningType -> winningType.matchCount == matchCount } ?: NONE_MATCH
    }
}
