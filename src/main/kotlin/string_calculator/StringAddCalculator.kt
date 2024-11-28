package string_calculator

class StringAddCalculator {
    fun calculate(input: String): Int {
        val operands = OperandsExtractor.extract(input)
        return operands.sum()
    }
}