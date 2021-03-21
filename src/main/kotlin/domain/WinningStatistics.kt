package domain

class WinningStatistics(val winningNumbers: LottoNumbers, val lottos: List<Lotto>) {
    val totalWinningPrizes: Money
        get() {
            return WinningCategory.values()
                .fold(Money.ZERO) { acc, category -> acc + sumPrizesOf(category) }
        }

    fun countLottoBy(category: WinningCategory): Int {
        return lottos.count { it.countMatchedBy(winningNumbers) == category.numberOfMatched }
    }

    private fun sumPrizesOf(category: WinningCategory) = category.prize * countLottoBy(category)
}
