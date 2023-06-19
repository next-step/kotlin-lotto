package lotto.sixFortyFiveNumberLotto

class SixFortyFiveLottoWinningResult(val countOfMatch: Int, val isMatchedBonus: Boolean) {
    companion object {
        fun of(
            lotto: List<SixFortyFiveNumber>,
            winningValue: SixFortyFiveWinningLotto,
        ): SixFortyFiveLottoWinningResult {
            val countOfMatch =
                lotto.count { number -> winningValue.getNumbers().find { it.value == number.value } != null }
            val isMatchedBonus =
                lotto.find { number -> number.value == winningValue.bonusNumber?.value } != null
            return SixFortyFiveLottoWinningResult(countOfMatch, isMatchedBonus)
        }
    }
}
