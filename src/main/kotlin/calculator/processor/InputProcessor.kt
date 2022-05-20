package calculator.processor

import calculator.model.PositiveNumber

class InputProcessor {
    fun convertStringToList(text: String?): List<PositiveNumber> {
        val notEmptyText = convertStringToZeroIfNull(text)
        return splitToDelimiter(notEmptyText)
            .map { PositiveNumber(it.trim()) }
    }

    private fun convertStringToZeroIfNull(text: String?) =
        if (text.isNullOrBlank()) {
            ZERO_STR
        } else {
            text
        }

    private fun splitToDelimiter(text: String): List<String> {
        val matchResult = Regex(CUSTOM_DELIMITER_REGEX_PATTERN).find(text)
        return matchResult?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: text.split(DEFAULT_DELIMITER_REGEX_PATTERN.toRegex())
    }

    companion object {
        private const val ZERO_STR = "0"
        private const val CUSTOM_DELIMITER_REGEX_PATTERN = """//(.)\\n(.*)"""
        private const val DEFAULT_DELIMITER_REGEX_PATTERN = ",|:"
    }
}
