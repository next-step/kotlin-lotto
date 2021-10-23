package calculator.domain

@JvmInline
value class Operand private constructor(val value: Int) {
    init {
        require(value >= 0) { ZERO_OR_NEGATIVE_NUMBER_ENTERED_MESSAGE }
    }

    operator fun plus(targetOperand: Operand): Operand {
        return Operand(value + targetOperand.value)
    }

    companion object {
        private const val MINIMUM_OPERAND_VALUE = 1
        private const val WRONG_OPERAND_ENTERED_MESSAGE = "잘못된 피연산자 입력입니다."
        private const val ZERO_OR_NEGATIVE_NUMBER_ENTERED_MESSAGE = "${MINIMUM_OPERAND_VALUE}이상의 피연산자를 입력 해 주세요."

        fun from(input: String): Operand {
            val value = parseValue(input)
            require(value != null) { WRONG_OPERAND_ENTERED_MESSAGE }
            return Operand(value)
        }

        private fun parseValue(input: String): Int? {
            if (input.isEmpty()) {
                return 0
            }

            return input.toIntOrNull()
        }
    }
}
