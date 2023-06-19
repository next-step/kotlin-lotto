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
            hasBonus = false,
        ),
    ),
    SECOND(
        winAmount = Money(30_000_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(5),
            hasBonus = true,
        ),
    ),
    THIRD(
        winAmount = Money(1_500_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(5),
            hasBonus = false,
        ),
    ),
    FOURTH(
        winAmount = Money(50_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(4),
            hasBonus = false
        ),
    ),
    FIFTH(
        winAmount = Money(5_000),
        matchCondition = MatchCondition(
            matchSuccessCount = PositiveNumber(3),
            hasBonus = false
        ),
    );

    companion object {
        fun findOrNull(matchCondition: MatchCondition): LottoWinRank? {
            return LottoWinRank.values().find { it.matchCondition == matchCondition }
        }
    }
}
