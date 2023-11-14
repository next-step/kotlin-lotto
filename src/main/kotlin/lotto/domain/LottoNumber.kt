package lotto.domain

import lotto.error.ErrorMessage.LOTTO_RANGE_ERROR

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in lottoNumberRange) { LOTTO_RANGE_ERROR.message }
    }

    companion object {
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        val lottoNumberRange: IntRange = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)
    }
}
