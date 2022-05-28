package lotto.domain

@JvmInline
value class LottoNumber private constructor(
    private val value: Int
) : Comparable<LottoNumber> {

    init {
        require(value in LOTTO_NUMBER_RANGE)
    }

    override fun compareTo(other: LottoNumber) = value.compareTo(other.value)

    override fun toString(): String = value.toString()

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45

        private val LOTTO_NUMBERS = LOTTO_NUMBER_RANGE.map { LottoNumber(it) }
            .associateBy { it.value }

        fun of(number: Int): LottoNumber {
            return LOTTO_NUMBERS[number] ?: throw IllegalArgumentException("로또 번호가 유효하지 않습니다.")
        }
    }
}
