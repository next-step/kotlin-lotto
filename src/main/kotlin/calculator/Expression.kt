package calculator

data class Expression(private val expression: String) {
    val delimiter: String = DEFAULT_DELIMITER

    fun syntax() = expression.substringAfter(CUSTOM_DELIMITER_SUFFIX)
        .replaceAll(delimiters(), DEFAULT_DELIMITER)

    private fun delimiters(): List<String> = expression.substringBetween(
        CUSTOM_DELIMITER_SUFFIX,
        CUSTOM_DELIMITER_PREFIX,
        orElse = DEFAULT_DELIMITERS
    ).map { it.toString() }

    companion object {
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\n"
        private const val DEFAULT_DELIMITERS = ":,"
        private const val DEFAULT_DELIMITER = ","
    }

    private fun String.substringBetween(
        open: String,
        close: String,
        orElse: String = this
    ): String {
        return substringBefore(open).substringAfter(close, orElse)
    }

    private fun String.replaceAll(search: List<String>, replacement: String): String {
        var result = this
        for (delimiter in search) {
            result = result.replace(delimiter, replacement)
        }
        return result
    }
}
