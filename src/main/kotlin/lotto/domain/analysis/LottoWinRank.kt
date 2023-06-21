package lotto.domain.analysis

import lotto.domain.money.Money

enum class LottoWinRank(
    val winAmount: Money,
    val matchCondition: MatchCondition,
) {
    FIRST(
        winAmount = Money(2_000_000_000),
        matchCondition = MatchCondition(
            matchSuccessCount = 6,
            isMatchedBonus = false,
        ),
    ),
    SECOND(
        winAmount = Money(30_000_000),
        matchCondition = MatchCondition(
            matchSuccessCount = 5,
            isMatchedBonus = true,
        ),
    ),
    THIRD(
        winAmount = Money(1_500_000),
        matchCondition = MatchCondition(
            matchSuccessCount = 5,
            isMatchedBonus = false,
        ),
    ),
    FOURTH(
        winAmount = Money(50_000),
        matchCondition = MatchCondition(
            matchSuccessCount = 4,
            isMatchedBonus = false
        ),
    ),
    FIFTH(
        winAmount = Money(5_000),
        matchCondition = MatchCondition(
            matchSuccessCount = 3,
            isMatchedBonus = false
        ),
    );

    companion object {
        fun findOrNull(matchCondition: MatchCondition): LottoWinRank? {
            return LottoWinRank.values().find { it.matchCondition == matchCondition }
        }
    }
}
