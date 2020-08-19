package lotto.domain

class LottoNumber private constructor(private val value: Int) {
    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith { LottoNumber(it) }

        fun get(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}
