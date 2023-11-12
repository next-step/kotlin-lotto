package lotto.domain

class Lotto(
    val autoLines: List<LottoLine>,
    val manualLines: List<LottoLine> = emptyList()
) {
    val allLines = autoLines + manualLines
    fun getAllSameNumberCount(lottoWinningNumber: LottoWinningNumber): List<LottoWinningResult> =
        allLines.map {
            val sameNumberCount = it.getSameNumberCount(lottoWinningNumber.winningNumbers)
            val isBonusMatch = it.isContainsBonusNumber(lottoWinningNumber.bonusNumber)
            LottoWinningResult(sameNumberCount, isBonusMatch)
        }
}
