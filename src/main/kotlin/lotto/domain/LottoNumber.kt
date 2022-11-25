package lotto.domain

import lotto.util.ErrorCode

data class LottoNumber(
    val number: Int
) {
    init {
        require(number in (LOTTO_START_NUMBER..LOTTO_END_NUMBER)) {
            ErrorCode.LOTTO_NUMBER_EXEPTION.errorMessage
        }
    }

    override fun toString(): String {
        return number.toString()
    }
    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45

        val possibleNumbers: List<LottoNumber> =
            (LOTTO_START_NUMBER..LOTTO_END_NUMBER).map { LottoNumber(it) }
    }
}
