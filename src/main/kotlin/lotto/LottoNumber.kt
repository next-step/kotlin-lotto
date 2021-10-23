package lotto

@JvmInline
value class LottoNumber private constructor(val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER) { throw IllegalArgumentException(NOT_NUMBER_RANGER) }
    }

    companion object {
        private const val NOT_NUMBER_RANGER = "로또의 범위가 아닙니다"
        private const val LOTTO_MINIMUM_NUMBER = 1
        private const val LOTTO_MAXIMUM_NUMBER = 45

        fun valueOf(value: Int): LottoNumber {
            return LottoNumber(value)
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number - other.number
    }
}
