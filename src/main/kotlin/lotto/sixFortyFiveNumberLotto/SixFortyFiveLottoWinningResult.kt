package lotto.sixFortyFiveNumberLotto

class SixFortyFiveLottoWinningResult(val countOfMatch: Int, val isMatchedBonus: Boolean) {
    companion object {
        fun of(
            numbers: SixFortyFiveLottoNumber,
            winningValue: SixFortyFiveLottoWinningNumber,
        ): SixFortyFiveLottoWinningResult {
            val countOfMatch = numbers.value.count { winningValue.value.contains(it) }
            val isMatchedBonus = numbers.value.contains(winningValue.bonusNumber)
            return SixFortyFiveLottoWinningResult(countOfMatch, isMatchedBonus)
        }
    }
}
