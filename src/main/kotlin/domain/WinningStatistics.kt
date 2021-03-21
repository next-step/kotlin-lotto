package domain

class WinningStatistics(val winningNumbers: LottoNumbers, val lottos: List<Lotto>) {
    val totalWinningPrizes: Money
        get() {
            return sumPrizesOf(WinningCategory.SIX_CORRECT) +
                sumPrizesOf(WinningCategory.FIVE_CORRECT) +
                sumPrizesOf(WinningCategory.FOUR_CORRECT) +
                sumPrizesOf(WinningCategory.THREE_CORRECT)
        }

    fun countLottoBy(category: WinningCategory): Int {
        return lottos.count { it.countMatchedBy(winningNumbers) == category.numberOfMatched }
    }

    private fun sumPrizesOf(category: WinningCategory) = category.prize * countLottoBy(category)
}
