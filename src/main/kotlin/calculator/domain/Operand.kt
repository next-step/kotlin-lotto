package calculator.domain

@JvmInline
value class Operand private constructor(val value: Int) {
    companion object {
        private const val WRONG_OPERAND_INPUT = "잘못된 피연산자 입력입니다."

        fun from(input: String?): Operand {
            val value = parseValue(input)
            require(value != null && value >= 0) { WRONG_OPERAND_INPUT }
            return Operand(value)
        }

        private fun parseValue(input: String?): Int? {
            if (input.isNullOrBlank()) {
                return 0
            }

            return input.toIntOrNull()
        }
    }
}
