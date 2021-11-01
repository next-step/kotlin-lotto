package calculator.domain

@JvmInline
value class Operands(val values: List<Operand>) {

    fun sumOf(): Int {
        return values.sumOf { it.value }
    }

    companion object {
        private val EMPTY_OPERANDS = Operands(listOf(Operand.ZERO))

        fun of(values: List<String>): Operands {
            if (values.isEmpty()) return EMPTY_OPERANDS
            return Operands(values.map { Operand.of(it) })
        }
    }
}
