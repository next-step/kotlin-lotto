package string_calculator

class StringAddCalculator(
    private val operandsExtractor: OperandsExtractor = OperandsExtractorImpl()
) {
    fun calculate(input: String): Int {
        val operands = operandsExtractor.extract(input)
        return operands.sum()
    }
}