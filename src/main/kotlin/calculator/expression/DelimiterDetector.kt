package calculator.expression

class DelimiterDetector private constructor(
    val delimiter: String,
    val stringInput: String
) {
    companion object {
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
        private const val DEFAULT_DELIMITER = "[,:]"

        fun from(input: String?): DelimiterDetector {
            val effectiveInput = if (input.isNullOrBlank()) "0" else input
            val customDelimiter = CUSTOM_DELIMITER_REGEX.find(effectiveInput)
            val delimiter = customDelimiter?.groupValues?.get(1)?.let { Regex.escape(it) } ?: DEFAULT_DELIMITER
            val stringInput = customDelimiter?.groupValues?.get(2) ?: effectiveInput
            return DelimiterDetector(delimiter, stringInput)
        }
    }
}
