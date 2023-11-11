package lotto.domain

import lotto.error.ErrorMessage.LOTTO_RANGE_ERROR

class LottoNumber private constructor(val number: Int) {
    init {
        require(number in lottoNumberRange) { LOTTO_RANGE_ERROR.message }
    }

    companion object {
        fun create(number: Int): LottoNumber {
            // 추가적인 로직이 필요하다면 여기에 구현
            return LottoNumber(number)
        }
        private const val LOTTO_FIRST_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        val lottoNumberRange: IntRange = (LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER)
    }
}
