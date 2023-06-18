package lotto.sixFortyFiveNumberLotto

class SixFortyFiveLottoWinningResult(val countOfMatch: Int, val isMatchedBonus: Boolean) {
    companion object {
        fun of(
            numbers: SixFortyFiveLottoNumber,
            winningValue: SixFortyFiveLottoWinningNumber,
        ): SixFortyFiveLottoWinningResult {
            val countOfMatch =
                numbers.value.count { number -> winningValue.value.find { it.value == number.value } != null }
            val isMatchedBonus = numbers.value.find { number -> number.value == winningValue.bonusNumber?.value } != null
            return SixFortyFiveLottoWinningResult(countOfMatch, isMatchedBonus)
        }
    }
}
