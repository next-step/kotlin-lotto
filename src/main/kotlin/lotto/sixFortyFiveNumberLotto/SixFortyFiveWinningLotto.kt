package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveWinningLotto(
    val lotto: SixFortyFiveLotto,
    private val bonusNumber: SixFortyFiveNumber? = null,
) {

    init {
        bonusNumber?.let {
            val isDuplicated = lotto.numbers.find { number -> number.value == bonusNumber.value } != null
            if (isDuplicated) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER.msg)
        }
    }

    fun matchCount(numbers: List<SixFortyFiveNumber>): SixFortyFiveLottoWinningResult {
        val countOfMatch = numbers.count { number -> this.lotto.numbers.find { it.value == number.value } != null }
        val isMatchedBonus = numbers.find { number -> number.value == this.bonusNumber?.value } != null
        return SixFortyFiveLottoWinningResult(countOfMatch, isMatchedBonus)
    }
}
