package lotto

@JvmInline
value class LottoNumber(private val value: Int = 0) {
    init {
        require(value in NUMBER_RANGE) { "1부터 45 사이의 숫자만 입력할 수 있습니다. [$value]" }
    }

    companion object {
        private val NUMBER_RANGE = 1..45
    }
}
