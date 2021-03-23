package domain.statistics

import domain.lotto.Lotto
import domain.lotto.LottoNumbers
import domain.money.Money

class WinningStatistics(val winningNumbers: LottoNumbers, val lottos: List<Lotto>) {
    val totalWinningPrizes: Money
        get() {
            return WinningCategory.values()
                .fold(Money.ZERO) { acc, category -> acc + sumPrizesOf(category) }
        }

    fun countLottoBy(category: WinningCategory): Int {
        return lottos.count { it.countMatchedBy(winningNumbers) == category.numberOfMatched }
    }

    fun calculateRatioOfIncomeToExpenditure(lottoPrice: Money): IncomeExpenditureRatio {
        return IncomeExpenditureRatio.calculatedBy(income = totalWinningPrizes, expenditure = calculateTotalExpenditure(lottoPrice))
    }

    private fun sumPrizesOf(category: WinningCategory) = category.prize * countLottoBy(category)

    private fun calculateTotalExpenditure(lottoPrice: Money): Money = lottoPrice * lottos.size
}
