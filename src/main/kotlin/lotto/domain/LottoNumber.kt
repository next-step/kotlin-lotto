package lotto.domain

import java.lang.IllegalArgumentException

data class LottoNumber(val value: Int) {

    companion object {
        val DEFAULT_RANGE = 1..45
        private val NUMBERS: Map<Int, LottoNumber> = DEFAULT_RANGE.associateWith(::LottoNumber)

        fun of(value: Int): LottoNumber {
            return NUMBERS.getOrElse(value) { throw IllegalArgumentException("Out of bounds : $value should be in 1 to 45") }
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
