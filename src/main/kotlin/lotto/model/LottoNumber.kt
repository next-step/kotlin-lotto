package lotto.model

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_WINNER_NUMBER_RANGE) { "1에서 45 사이의 값을 입력하세요." }
    }

    constructor(value: String) : this(convert(value))

    companion object {
        private val LOTTO_WINNER_NUMBER_RANGE = 1..45
        private fun convert(input: String) = input.toIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다.")
    }
}
