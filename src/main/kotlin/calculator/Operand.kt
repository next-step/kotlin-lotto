package calculator

@JvmInline
value class Operand private constructor(val value: Int) {
    companion object {
        fun from(expression: String): Operand {
            val number = expression.toIntOrNull()
            require(number != null && number >= 0) { "음수 또는 숫자가 아닌 값을 입력할 수 없습니다." }
            return Operand(value = number)
        }
    }
}
