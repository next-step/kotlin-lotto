package string.addition.calculator.domain

object Splitter {
    private const val DEFAULT_DELIMITER = ",|:"
    private const val DELIMITER_SEPARATOR = "|"
    private const val UNIFIED_DELIMITER = ","
    private const val CUSTOM_DELIMITER_PREFIX = "//"
    private const val CUSTOM_DELIMITER_SUFFIX = "\\n"
    const val DEFAULT_NUMBER = "0"

    fun split(input: String, delimiters: List<String>): List<String> {
        val normalizeForSplit = normalizeForSplit(input, delimiters)
        if (normalizeForSplit.isBlank()) {
            return listOf(DEFAULT_NUMBER)
        }
        return normalizeForSplit.split(UNIFIED_DELIMITER)
    }

    private fun normalizeForSplit(input: String, delimiters: List<String>): String {
        var normalizedString: String = input
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            normalizedString = input.substringAfter(CUSTOM_DELIMITER_SUFFIX)
        }
        delimiters.forEach { normalizedString = normalizedString.replace(it, UNIFIED_DELIMITER) }
        return normalizedString
    }

    fun getDelimiters(input: String): List<String> {
        val delimiters = DEFAULT_DELIMITER.split(DELIMITER_SEPARATOR).toMutableList()
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            delimiters.add(input.substringAfter(CUSTOM_DELIMITER_PREFIX).substringBefore(CUSTOM_DELIMITER_SUFFIX))
        }
        return delimiters
    }
}
