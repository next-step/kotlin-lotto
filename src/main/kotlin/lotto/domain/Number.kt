package lotto.domain

@JvmInline
value class Number(val value: Int) {
    init {
        require(value in NUMBER_RANGE) { NUMBER_RANGE_EXCEPTION_MESSAGE }
    }

    companion object {
        private const val NUMBER_RANGE_EXCEPTION_MESSAGE = "숫자는 1~45의 값이어야 합니다."
        val NUMBER_RANGE = IntRange(1, 46)
    }
}