package lotto.domain

@JvmInline
value class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {

    init {
        require(value in VALID_LOTTO_RANGE) { "${value}이/가 1~45 범위 내에 있어야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int {
        return compareValues(value, other.value)
    }

    companion object {
        private val VALID_LOTTO_RANGE = 1..45

        fun valueOf(value: Int): LottoNumber {
            return VALID_LOTTO_NUMBERS.getOrNull(value - 1) ?: LottoNumber(value)
        }

        fun valueOf(value: String): LottoNumber {
            val lottoNumber = value.toIntOrNull() ?: throw IllegalArgumentException("${value}은/는 정수가 아닙니다.")
            return valueOf(lottoNumber)
        }

        val VALID_LOTTO_NUMBERS = VALID_LOTTO_RANGE.toList().map(::LottoNumber)
    }
}
