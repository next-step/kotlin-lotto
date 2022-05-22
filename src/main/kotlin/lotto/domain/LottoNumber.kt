package lotto.domain

import lotto.exception.InvalidLottoNumberException

@JvmInline
value class LottoNumber(val number: Int) {

    init {
        require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            throw InvalidLottoNumberException()
        }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45

        fun all(): IntRange {
            return (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        }
    }
}
