package lotto.domain

class LottoNumber private constructor(val value: Int) {

    override fun toString(): String {
        return "$value"
    }

    companion object {

        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        val numbers: List<LottoNumber> = (MIN_NUMBER..MAX_NUMBER).map(::LottoNumber)

        fun of(value: Int): LottoNumber {
            require(value in (MIN_NUMBER..MAX_NUMBER)) { "out of range value[$value]" }

            return numbers[value - 1]
        }
    }
}
