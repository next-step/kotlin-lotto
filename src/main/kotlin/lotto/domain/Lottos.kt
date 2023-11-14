package lotto.domain

class Lottos(
    val lines: List<LottoLine>,
    val autoQuantity: Int,
    val manualQuantity: Int
) {
    fun getAllSameNumberCount(lottoWinningNumber: LottoWinningNumber): List<LottoWinningResult> =
        lines.map {
            val sameNumberCount = it.getSameNumberCount(lottoWinningNumber.winningNumbers)
            val isBonusMatch = it.isContainsNumber(lottoWinningNumber.bonusNumber)
            LottoWinningResult(sameNumberCount, isBonusMatch)
        }
}
