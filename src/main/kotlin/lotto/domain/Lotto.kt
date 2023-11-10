package lotto.domain

class Lotto(
    val lines: List<LottoNumber>
) {
    fun getAllSameNumberCount(lottoWinningNumber: LottoWinningNumber): List<LottoWinningResult> =
        lines.map {
            val sameNumberCount = it.getSameNumberCount(lottoWinningNumber.winningNumbers)
            val isBonusMatch = it.isContainsBonusNumber(lottoWinningNumber.bonusNumber)
            LottoWinningResult(sameNumberCount, isBonusMatch)
        }
}
