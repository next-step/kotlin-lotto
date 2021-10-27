package lotto.domain

@JvmInline
value class LottoNumber private constructor(val number: Int) : Comparable<LottoNumber> {

    init {
        require(number in LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER) { throw IllegalArgumentException(NOT_NUMBER_RANGER) }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number - other.number
    }
    companion object {
        private const val NOT_NUMBER_RANGER = "로또의 범위가 아닙니다"
        private const val LOTTO_MINIMUM_NUMBER = 1
        private const val LOTTO_MAXIMUM_NUMBER = 45
        private val CACHE = (LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER).map { LottoNumber(it) }

        fun valueOf(value: Int): LottoNumber {
            return CACHE.find { it == LottoNumber(value) }?.let { it } ?: LottoNumber(value)
        }

        fun getLottoNumbers(): List<LottoNumber> {
            return CACHE
        }
    }
}
