package lotto.agency.number

import lotto.exception.LottoNumberPolicyException

data class LottoNumber(val number: Int) {

    init {
        validateLottoNumber(number)
    }

    private fun validateLottoNumber(number: Int) {
        if (!LOTTO_NUMBER_RANGE.contains(number)) {
            throw LottoNumberPolicyException("로또 번호의 범위는 ${LOTTO_NUMBER_RANGE.first}부터 ${LOTTO_NUMBER_RANGE.last}까지 입니다.")
        }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = IntRange(1, 45)
        private val NUMBERS : Map<Int, LottoNumber> = LOTTO_NUMBER_RANGE.associateWith(::LottoNumber)

        fun valueOf(value: Int) : LottoNumber{
            return NUMBERS[value] ?: throw IllegalArgumentException()
        }
    }
}
