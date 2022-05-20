package calculator.processor

class InputProcessor {
    fun convertStringToList(text: String?): List<String> {
        val notEmptyText = convertStringToZeroIfNull(text)
        val tokens = notEmptyText.split(DEFAULT_DELIMITER_REGEX.toRegex())
        println(tokens)
        return tokens
    }

    private fun convertStringToZeroIfNull(text: String?) =
        if (text.isNullOrBlank()) {
            ZERO_STR
        } else {
            text
        }

    companion object {
        private const val ZERO_STR = "0"
        private const val DEFAULT_DELIMITER_REGEX = ",|:"
    }
}
