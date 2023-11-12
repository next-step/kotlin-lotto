package calculator

data class PositiveNumber(val number: Int) {

    init {
        require(number > 0) { throw RuntimeException(NEGATIVE_MESSAGE) }
    }

    companion object {
        private const val NEGATIVE_MESSAGE = "음수 입력되었습니다!!!!"
    }
}
