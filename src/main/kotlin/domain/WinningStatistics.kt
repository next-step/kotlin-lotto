package domain

class WinningStatistics(val winningNumbers: LottoNumbers, val lottos: List<Lotto>, lottoUnitPrice: Money) {
    fun countLottoBy(category: WinningCategory): Int {
        return lottos.count { it.countMatchedBy(winningNumbers) == category.numberOfMatched }
    }
}
