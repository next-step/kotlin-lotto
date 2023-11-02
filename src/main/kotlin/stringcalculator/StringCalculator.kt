package stringcalculator

class StringCalculator(
    private val validator: Validator,
    private val stringParser: StringParser
) {

    fun sum(input: String): Int {
        if (stringParser.hasCustomDelimiter(input)) {
            return sumWithCustomDelimiter(input)
        }
        return sumWithDefaultDelimiter(input)
    }

    private fun sumWithCustomDelimiter(input: String): Int {
        val parseDelimiter = stringParser.parseDelimiter(input)
        val operations = stringParser.parse(parseDelimiter.data, parseDelimiter.delimiter)
        validator.ensureAllPositiveNumbers(operations)
        return sumOfOperations(operations)
    }

    private fun sumWithDefaultDelimiter(input: String): Int {
        val operations = stringParser.parse(input)
        validator.ensureAllPositiveNumbers(operations)
        return sumOfOperations(operations)
    }

    private fun sumOfOperations(operations: List<String>) = operations.sumOf { it.toInt() }
}
