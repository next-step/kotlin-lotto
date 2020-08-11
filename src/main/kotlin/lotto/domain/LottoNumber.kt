package lotto.domain

import java.lang.IllegalArgumentException

data class LottoNumber(val value: Int?) {

    companion object {
        val DEFAULT_RANGE = 1..45
        private val NUMBERS: Map<Int, LottoNumber> = DEFAULT_RANGE.associateWith(::LottoNumber)

        fun of(value: Int?): LottoNumber {
            require(value != null) { "Non-numeric value" }
            return NUMBERS.getOrElse(value) { throw IllegalArgumentException("LottoNumber($value) should be between 1 and 45") }
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
