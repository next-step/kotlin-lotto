package lotto.dto

import lotto.entity.Rank

data class LottoResultForView(
    val rankToHowManyWins: Map<Rank, Int>,
    val rateOfReturn: Double,
)
