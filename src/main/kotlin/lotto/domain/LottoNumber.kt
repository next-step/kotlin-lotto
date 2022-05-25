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
        private val numbers: Map<Int, LottoNumber> = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
            .associateWith { LottoNumber(it) }

        fun all(): IntRange {
            return (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        }

        fun of(number: Int): LottoNumber {
            return numbers[number] ?: throw InvalidLottoNumberException()
        }
    }
}
