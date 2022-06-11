package lotto.domain

@JvmInline
value class LottoNumber private constructor(private val value: Int) {
    init {
        require(value in LOTTO_START_NUMBER..LOTTO_END_NUMBER) { LOTTO_RANGE_MESSAGE }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        private const val LOTTO_RANGE_MESSAGE = "로또 번호는 1 ~ 45 사이의 숫자이어야 합니다."
        private val NUMBERS: Map<Int, LottoNumber> = (LOTTO_START_NUMBER..LOTTO_END_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return "$value"
    }
}
