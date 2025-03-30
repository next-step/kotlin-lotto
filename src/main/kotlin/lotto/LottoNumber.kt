package lotto

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { ERROR_RANGE }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val ERROR_RANGE = "Lotto number should be in between 1 and 45"
    }
}
