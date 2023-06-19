package lotto.domain.analysis

import lotto.domain.money.Money
import math.PositiveNumber

enum class LottoWinRank(
    val winAmount: Money,
    val matchCondition: MatchCondition,
) {
    FIRST(
        winAmount = Money(2_000_000_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(6),
        ),
    ),
    SECOND(
        winAmount = Money(1_500_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(5),
        ),
    ),
    THIRD(
        winAmount = Money(50_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(4),
        ),
    ),
    FOURTH(
        winAmount = Money(5_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(3),
        ),
    );

    companion object {
        fun findOrNull(matchCondition: MatchCondition): LottoWinRank? {
            return LottoWinRank.values().find { it.matchCondition == matchCondition }
        }
    }
}
