package stringaddcalculator.domain

class StringAddCalculator(
    private val separators: Separators = Separators()
) {

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return 0

        val operands = extractOperands(input)

        return Adder.add(operands)
    }

    private fun extractOperands(input: String): List<Operand> {
        println(separators.toRegex())
        return input.split(separators.toRegex())
            .map { Operand(it.toInt()) }
    }
}
