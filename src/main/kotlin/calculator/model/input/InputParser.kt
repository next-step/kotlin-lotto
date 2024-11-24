package calculator.model.input

object InputParser {
    private val DEFAULT_DELIMITERS = arrayOf(",", ":")

    fun parse(input: String?): List<Int> {
        if (input.isNullOrEmpty()) return listOf(0)
        val (customDelimiter, numberInput) = extractDelimiterAndNumbers(input)
        val delimiters = combineDelimiters(customDelimiter)
        val tokens = splitInputByDelimiters(numberInput, delimiters)
        val numbers = parseNonNegativeNumbers(tokens)
        val nonNumeric = extractNonNumericCharacters(numberInput)
        InputValidator.validateDelimiters(nonNumeric, delimiters)
        InputValidator.validateNumbers(numbers)
        return numbers
    }

    private fun extractDelimiterAndNumbers(input: String): Pair<String?, String> {
        val result = Regex("//(.)\n(.*)").find(input)
        return if (result != null) {
            val customDelimiter = result.groupValues[1]
            val numbers = result.groupValues[2]
            customDelimiter to numbers
        } else {
            null to input
        }
    }

    private fun combineDelimiters(customDelimiter: String?): Array<String> {
        return mutableListOf(*DEFAULT_DELIMITERS).apply {
            customDelimiter?.let(::add)
        }.toTypedArray()
    }

    private fun splitInputByDelimiters(
        numberInput: String,
        delimiters: Array<String>,
    ): List<String> {
        return numberInput.split(*delimiters)
    }

    private fun parseNonNegativeNumbers(tokens: List<String>): List<Int> {
        return tokens.map { token ->
            token.toIntOrNull() ?: -1
        }
    }

    private fun extractNonNumericCharacters(input: String): List<String> {
        return input.replace(Regex("-?\\d+"), "").trim()
            .map { "$it" }
    }
}
