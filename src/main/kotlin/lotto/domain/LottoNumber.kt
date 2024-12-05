package lotto.domain

class LottoNumber private constructor(private val number: Int) {
    init {
        require(number in 1..45) { INVALID_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        const val INVALID_LOTTO_NUMBER_MESSAGE: String = "로또 번호는 1부터 45사이의 숫자만 가능합니다."

        private val ALL_LOTTO_NUMBERS = (1..45).map { LottoNumber(it) }

        fun of(number: Int): LottoNumber {
            require(number in 1..45) { INVALID_LOTTO_NUMBER_MESSAGE }
            return ALL_LOTTO_NUMBERS[number - 1]
        }
    }
}
