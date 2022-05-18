package stringaddcalculator.domain

@JvmInline
value class Operand(val value: Int) {
    operator fun plus(other: Operand): Operand = Operand(value + other.value)
}
