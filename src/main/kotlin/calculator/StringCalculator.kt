package calculator

class StringCalculator {

    fun add(input: String?): Int = if (input.isNullOrBlank()) 0 else getNumbers(input).sumOf { it.number }

    private fun getNumbers(input: String): List<PositiveNumber> =
        (getCustomDelimiterTokens(input) ?: getPredefinedDelimiterTokens(input)).map { it.toPositiveNumber() }

    private fun getCustomDelimiterTokens(input: String): List<String>? =
        REGEX_CUSTOM_DELIMITER.find(input)?.let {
            val (delimiter, tokens) = it.destructured
            tokens.split(delimiter)
        }

    private fun getPredefinedDelimiterTokens(input: String): List<String> =
        input.split(',', ':')

    companion object {
        private val REGEX_CUSTOM_DELIMITER = Regex("//(.)\n(.*)")
    }
}
