package lotto.domain

import java.lang.IllegalArgumentException

data class LottoNumber(val value: Int) {

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith(::LottoNumber)

        fun of(value: Int): LottoNumber {
            return NUMBERS.getOrElse(value) { throw IllegalArgumentException("Out of bounds : $value should be in 1 to 45") }
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
