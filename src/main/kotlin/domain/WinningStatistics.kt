package domain

class WinningStatistics(val winningNumbers: LottoNumbers, val lottos: List<Lotto>, lottoUnitPrice: Money) {
    val totalWinningPrizes: Money
        get() {
            return (WinningCategory.SIX_CORRECT.prize * countLottoBy(WinningCategory.SIX_CORRECT)) +
                (WinningCategory.FIVE_CORRECT.prize * countLottoBy(WinningCategory.FIVE_CORRECT)) +
                (WinningCategory.FOUR_CORRECT.prize * countLottoBy(WinningCategory.FOUR_CORRECT)) +
                (WinningCategory.THREE_CORRECT.prize * countLottoBy(WinningCategory.THREE_CORRECT))
        }

    fun countLottoBy(category: WinningCategory): Int {
        return lottos.count { it.countMatchedBy(winningNumbers) == category.numberOfMatched }
    }
}
