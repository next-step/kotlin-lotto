package domain.calculator.domain.operand

@JvmInline
value class PositiveOperand(val operand: Int) {
    init {
        if (operand < MINIMUM) throw RuntimeException(LESS_THAN_MINIMUM_EXCEPTION_MESSAGE)
    }

    constructor(operand: String) : this(
        operand.toIntOrNull()
            ?: throw RuntimeException(NOT_PARSING_OPERAND_MESSAGE)
    )

    companion object {
        private const val LESS_THAN_MINIMUM_EXCEPTION_MESSAGE = "CalculateResult, 최소 값 이하의 값은 입력될 수 없습니다."
        private const val NOT_PARSING_OPERAND_MESSAGE = "해당 문자열은 피연산자가 될 수 없습니다."
        private const val MINIMUM = 0
    }
}
