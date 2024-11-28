package lotto.domain

class LottoNumber private constructor(val number: Int) {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45

        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        return number == other.number
    }

    override fun hashCode(): Int {
        return number
    }
}
