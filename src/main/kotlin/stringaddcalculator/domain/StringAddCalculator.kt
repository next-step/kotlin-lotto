package stringaddcalculator.domain

class StringAddCalculator(
    private val tokenizer: StringTokenizer = StringTokenizer(),
) {
    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) return 0
        val operands = tokenizer.tokens(input)
            .map { Operand.of(it) }

        return operands.sumOf { it.value }
    }
}
