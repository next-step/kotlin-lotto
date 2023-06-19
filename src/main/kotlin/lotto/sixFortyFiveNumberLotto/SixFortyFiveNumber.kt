package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveNumber(val value: Int) {
    init {
        if (value < LOTTO_NUMBER_RANGE_START || value > LOTTO_NUMBER_RANGE_END) throw RuntimeException(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg)
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        private const val LOTTO_NUMBER_RANGE_START = 1
        private const val LOTTO_NUMBER_RANGE_END = 45
    }
}
