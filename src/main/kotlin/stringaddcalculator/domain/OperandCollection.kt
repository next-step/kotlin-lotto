package stringaddcalculator.domain

class OperandCollection(private val numbers: List<Operand>) {
    companion object {
        fun of(stringNumbers: List<String>): OperandCollection {
            val numbers = stringNumbers.map { Operand.of(it) }
            return OperandCollection(numbers)
        }

        private const val INITIAL_NUMBER = 0
    }

    fun plusAllNumbers(): Operand {
        return numbers
            .fold(Operand(INITIAL_NUMBER)) { a, b -> a + b }
    }
}
