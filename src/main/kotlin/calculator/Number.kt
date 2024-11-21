package calculator

@JvmInline
value class Number(val value: Int) {
    init {
        require(value >= 0) { NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val NUMBER_ERROR_MESSAGE = "숫자는 음수가 될 수 없습니다."
    }
}
