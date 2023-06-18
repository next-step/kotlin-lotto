package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveLottoWinningNumber(_value: List<SixFortyFiveNumber>) : SixFortyFiveLottoNumber(_value) {
    override val value: List<SixFortyFiveNumber>
        get() {
            if (bonusNumber == null) return super.value
            return listOf(*super.value.toTypedArray(), bonusNumber!!)
        }
    var bonusNumber: SixFortyFiveNumber? = null
        set(value) {
            if (value == null) return
            val isDuplicated = super.value.find { number -> number.value == value.value } != null
            if (isDuplicated) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER.msg)
            field = value
        }
}
