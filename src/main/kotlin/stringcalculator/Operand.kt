package stringcalculator

@JvmInline
value class Operand(val value: Int) {

    init {
        require(value >= 0) { "음수일 수 없습니다." }
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
