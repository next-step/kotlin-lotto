package lotto.workflow

import lotto.dto.LottoResultForView
import lotto.entity.Rank

object MakeLottoResult {
    operator fun invoke(rankToHowManyWins: Map<Rank, Int>, purchaseCost: Double): LottoResultForView {
        return LottoResultForView(rankToHowManyWins, rankToHowManyWins.calculateRateOfReturn(purchaseCost))
    }

    private fun Map<Rank, Int>.calculateRateOfReturn(purchaseCost: Double): Double =
        this.entries.sumOf { (rank, howManyWins) -> howManyWins * rank.prize }
            .toDouble() / purchaseCost
}
