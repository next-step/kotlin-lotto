package lotto.domain

@JvmInline
value class LottoNumber private constructor(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE) { INVALID_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        const val LOTTO_NUMBER_MIN_VALUE: Int = 1
        const val LOTTO_NUMBER_MAX_VALUE: Int = 45

        const val INVALID_LOTTO_NUMBER_MESSAGE: String = "로또 번호는 1부터 45사이의 숫자만 가능합니다."

        private val ALL_LOTTO_NUMBERS_MAP: Map<Int, LottoNumber> =
            (LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).associateWith { LottoNumber(it) }

        fun of(number: Int): LottoNumber {
            return ALL_LOTTO_NUMBERS_MAP[number] ?: throw IllegalArgumentException(INVALID_LOTTO_NUMBER_MESSAGE)
        }
    }
}
