package calculator.domain

object OperationParser {

    private val DEFAULT_DELIMITERS_REGEX = "[,:]".toRegex()
    private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()

    fun parse(operation: String): OperationTokens {
        val result = splitOperation(operation)

        return OperationTokens(result)
    }

    private fun splitOperation(operation: String): List<String> {
        val matchResult = CUSTOM_DELIMITER_REGEX.find(operation)
        val result = matchResult?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: operation.split(DEFAULT_DELIMITERS_REGEX)

        return result
    }
}
