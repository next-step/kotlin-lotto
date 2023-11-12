package lotto.domain

class Lotto(
    val autoLines: List<LottoLine>,
    val manualLines: List<LottoLine> = emptyList()
) {
    fun getAllSameNumberCount(lottoWinningNumber: LottoWinningNumber): List<LottoWinningResult> =
        autoLines.map {
            val sameNumberCount = it.getSameNumberCount(lottoWinningNumber.winningNumbers)
            val isBonusMatch = it.isContainsBonusNumber(lottoWinningNumber.bonusNumber)
            LottoWinningResult(sameNumberCount, isBonusMatch)
        }
}
