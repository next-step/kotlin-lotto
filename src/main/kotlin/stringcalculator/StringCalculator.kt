package stringcalculator

class StringCalculator(
    private val validator: Validator,
    private val numberSumCalculator: NumberSumCalculator,
    private val stringParser: StringParser
) {

    fun sum(input: String): Int {
        if (stringParser.hasCustomDelimiter(input)) {
            return sumWithCustomDelimiter(input)
        }
        return sumWithDefaultDelimiter(input)
    }

    private fun sumWithDefaultDelimiter(input: String): Int {
        val target = stringParser.parse(input)
        validator.ensureAllPositiveNumbers(target)
        return numberSumCalculator.sum(target.map { it.toInt() })
    }

    private fun sumWithCustomDelimiter(input: String): Int {
        val parseDelimiter = stringParser.parseDelimiter(input)
        val target = stringParser.parse(parseDelimiter.data, parseDelimiter.delimiter)
        validator.ensureAllPositiveNumbers(target)
        return numberSumCalculator.sum(target.map { it.toInt() })
    }
}
