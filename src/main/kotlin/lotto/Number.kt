package lotto

class Number(val value: Int) {
    init {
        require(value > 0) { NUMBER_INIT_EXCEPTION_MESSAGE }
    }

    companion object {
        private const val NUMBER_INIT_EXCEPTION_MESSAGE = "숫자는 0이 아닌 양수여야 합니다."
    }
}
