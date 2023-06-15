package stringcalculator

@JvmInline
value class Operand(val value: Int) {

    init {
        require(value >= 0) { "피연산자는 음수일 수 없습니다." }
    }

    operator fun plus(operand: Operand): Operand {
        return Operand(value + operand.value)
    }

    companion object {
        private val DEFAULT_OPERAND = Operand(0)
        fun of(input: String): Operand {
            val value = input.trim()
            if (value.isEmpty()) {
                return DEFAULT_OPERAND
            }
            return Operand(value.toInt())
        }
    }
}
