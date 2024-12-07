package lotto.domain

class LottoNumber private constructor(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE) { INVALID_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        const val LOTTO_NUMBER_MIN_VALUE: Int = 1
        const val LOTTO_NUMBER_MAX_VALUE: Int = 45

        const val INVALID_LOTTO_NUMBER_MESSAGE: String = "로또 번호는 1부터 45사이의 숫자만 가능합니다."

        private val ALL_LOTTO_NUMBERS = (LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).map { LottoNumber(it) }

        fun of(number: Int): LottoNumber {
            require(number in LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE) { INVALID_LOTTO_NUMBER_MESSAGE }
            return ALL_LOTTO_NUMBERS[number - 1]
        }
    }
}
