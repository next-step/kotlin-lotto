package calculator

object StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val operands = StringInputParser.parse(input)

        return operands.run {
            validateNonNegative()
            sum()
        }
    }
}
