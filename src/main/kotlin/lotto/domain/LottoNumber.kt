package lotto.domain

fun Iterable<Int>.toLottoNumberSet(): Set<LottoNumber> {
    return this.map(LottoNumber.Companion::from).toSet()
}

@JvmInline
value class LottoNumber private constructor(private val value: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }

    override fun toString(): String {
        return "$value"
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private val LOTTO_RANGE = MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER
        val LOTTO_NUMBERS = LOTTO_RANGE.map(::LottoNumber)

        fun from(value: Int): LottoNumber {
            require(value in LOTTO_RANGE) {
                "lotto number must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER"
            }
            return LottoNumber(value)
        }
    }
}
