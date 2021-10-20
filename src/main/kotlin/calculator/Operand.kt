package calculator

data class Operand(val value: Int) {
    companion object {
        private const val WRONG_OPERAND_INPUT = "잘못된 피연산자 입력입니다."

        fun from(input: String?): Operand {
            val inputOperandValue = input?.toIntOrNull()
            require(inputOperandValue != null && inputOperandValue >= 0) { WRONG_OPERAND_INPUT }
            return Operand(inputOperandValue)
        }
    }
}
