package lotto.domain

data class LottoNumber(private val number: Int) {

    companion object {
        private const val NUMBER_START = 1
        private const val NUMBER_END = 45
        val NUMBER_RANGE = NUMBER_START..NUMBER_END
        private val NUMBERS: Map<Int, LottoNumber> = (NUMBER_RANGE).associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("범위에 벗어난 숫자입니다.")
        }
    }
}
