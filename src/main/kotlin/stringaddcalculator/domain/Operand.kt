package stringaddcalculator.domain

@JvmInline
value class Operand(val value: Int) {

    init {
        if (value < MINIMUM_VALUE) throw RuntimeException("음수는 피연산자가 될 수 없습니다.")
    }

    operator fun plus(other: Operand): Operand = Operand(value + other.value)

    companion object {
        private const val MINIMUM_VALUE = 0
    }
}
