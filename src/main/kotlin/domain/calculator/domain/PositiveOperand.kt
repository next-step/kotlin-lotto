package domain.calculator.domain

@JvmInline
value class PositiveOperand(val operand: Int) {
    init {
        if (operand < MINIMUM) throw RuntimeException(LESS_THAN_MINIMUM_EXCEPTION_MESSAGE)
    }

    companion object {
        private const val LESS_THAN_MINIMUM_EXCEPTION_MESSAGE = "CalculateResult, 최소 값 이하의 값은 입력될 수 없습니다."
        private const val MINIMUM = 0

        fun of(operand: String): PositiveOperand = PositiveOperand(operand.toInt())
    }
}