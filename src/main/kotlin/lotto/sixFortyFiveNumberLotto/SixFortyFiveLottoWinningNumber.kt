package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveLottoWinningNumber(_value: List<Int>) : SixFortyFiveLottoNumber(_value) {
    override val value: List<Int>
        get() {
            if (bonusNumber == null) return super.value
            return listOf(*super.value.toTypedArray(), bonusNumber!!)
        }
    var bonusNumber: Int? = null
        set(value) {
            if (value == null) return
            val isDuplicated = super.value.contains(value)
            if (!validSingleNumber(value) || isDuplicated) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_BONUS_LOTTO_NUMBER.msg)
            field = value
        }
}
