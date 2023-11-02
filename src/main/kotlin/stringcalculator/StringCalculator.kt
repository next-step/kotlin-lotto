package stringcalculator

class StringCalculator(
    private val validator: Validator,
    private val stringParser: StringParser
) {

    fun sum(numbersAsString: String): Int {
        if (stringParser.hasCustomDelimiter(numbersAsString)) {
            return sumWithCustomDelimiter(numbersAsString)
        }
        return sumWithDefaultDelimiter(numbersAsString)
    }

    private fun sumWithCustomDelimiter(numbersAsString: String): Int {
        val parseDelimiter = stringParser.parseDelimiter(numbersAsString)
        val operations = stringParser.parse(parseDelimiter.data, parseDelimiter.delimiter)
        validator.ensureAllPositiveNumbers(operations)
        return sumOfOperations(operations)
    }

    private fun sumWithDefaultDelimiter(numbersAsString: String): Int {
        val operations = stringParser.parse(numbersAsString)
        validator.ensureAllPositiveNumbers(operations)
        return sumOfOperations(operations)
    }

    private fun sumOfOperations(operations: List<String>) = operations.sumOf { it.toInt() }
}
