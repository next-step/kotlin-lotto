package lotto.domain.analysis

import math.PositiveNumber

data class MatchCondition(
    val matchSuccessCount: PositiveNumber,
    val isMatchedBonus: Boolean,
)
