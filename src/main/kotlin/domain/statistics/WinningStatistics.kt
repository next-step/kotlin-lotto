package domain.statistics

import domain.lotto.LottoNumbers
import domain.lotto.Lottos
import domain.money.Money

class WinningStatistics(val winningNumbers: LottoNumbers, val lottos: Lottos) {

    fun calculateRatioOfIncomeToExpenditure(lottoPrice: Money): IncomeExpenditureRatio {
        return IncomeExpenditureRatio.calculatedBy(
            income = sumPrizes(),
            expenditure = lottoPrice * lottos.size
        )
    }

    private fun sumPrizes(): Money {
        return lottos.matches(winningNumbers)
            .map { (category, matchCount) -> category.prize * matchCount }
            .fold(Money.ZERO) { acc, money -> acc + money }
    }
}
