package model

class LottoNumber private constructor(val value: Int) {
    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45

        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS.getOrElse(value) { throw IllegalArgumentException() }
        }
    }
}
