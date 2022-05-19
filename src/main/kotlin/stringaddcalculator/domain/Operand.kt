package stringaddcalculator.domain

@JvmInline
value class Operand(val value: Int) {

    init {
        if (value < MINIMUM_VALUE) throw RuntimeException("음수는 피연산자가 될 수 없습니다.")
    }

    operator fun plus(other: Operand): Operand = Operand(value + other.value)

    companion object {
        private const val MINIMUM_VALUE = 0

        fun of(stingValue: String): Operand {
            val value = stingValue.toIntOrNull() ?: throw NumberFormatException("숫자가 아닌 문자입니다.")
            return Operand(value)
        }
    }
}
