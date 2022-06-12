package calculator

private fun Int.isNegativeNumber(): Boolean {
    return this < 0
}

@JvmInline
value class Operand private constructor(
    val operand: Int
) {
    companion object {
        val DEFAULT = Operand(0)

        fun from(input: String): Operand {
            val operand = input.toIntOrNull() ?: throw RuntimeException("피연산자는 숫자만 입력하실 수 있습니다.")

            if (operand.isNegativeNumber()) {
                throw RuntimeException("피연산자는 0이상의 수만 입력하실 수 있습니다.")
            }

            return Operand(operand)
        }
    }
}
