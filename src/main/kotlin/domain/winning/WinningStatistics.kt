package domain.winning

import domain.lotto.Lottos
import domain.money.Money

class WinningStatistics(val winningNumbers: WinningNumbers, val lottos: Lottos) {
    fun calculateRatioOfIncomeToExpenditure(lottoPrice: Money): IncomeExpenditureRatio {
        return IncomeExpenditureRatio.calculatedBy(
            income = sumPrizes(),
            expenditure = lottoPrice * lottos.size
        )
    }

    private fun sumPrizes(): Money {
        return lottos.toList()
            .map { winningNumbers.determineWinning(it) }
            .fold(Money.ZERO) { acc, category -> acc + category.prize }
    }
}
