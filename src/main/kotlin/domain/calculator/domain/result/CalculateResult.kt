package domain.calculator.domain.result

@JvmInline
value class CalculateResult(val result: Int) {
    init {
        if (result < MINIMUM) throw RuntimeException(LESS_THAN_MINIMUM_EXCEPTION_MESSAGE)
    }

    companion object {
        private const val LESS_THAN_MINIMUM_EXCEPTION_MESSAGE = "CalculateResult, 최소 값 이하의 값은 입력될 수 없습니다."
        private const val MINIMUM = 0;
    }
}
