package lotto.domain

@JvmInline
value class LottoNumber(private val number: Int) {

    init {
        require(number in NUMBER_RANGE) { "범위에 벗어난 숫자입니다." }
    }

    companion object {
        private const val NUMBER_START = 1
        private const val NUMBER_END = 45
        val NUMBER_RANGE = NUMBER_START..NUMBER_END
    }
}
