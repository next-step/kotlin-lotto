package calculator.application.parser.model

class CustomDelimiter(
    override val value: String
) : Delimiter {

    companion object {

        fun hasCustomDelimiter(inputString: String) = regex.find(inputString) != null

        fun findCustomDelimiters(inputString: String): Delimiter {
            val delimiter = regex.find(inputString)?.groupValues?.get(1) ?: throw RuntimeException("구분자 조회 중 에러가 발생했습니다")
            return CustomDelimiter(delimiter)
        }

        fun cleanDelimiter(inputString: String, customDelimiterValue: String): String {
            return inputString.replace("$CUSTOM_DELIMITER_PREFIX${customDelimiterValue}$CUSTOM_DELIMITER_SUFFIX", EMPTY_STRING)
        }

        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "\n"
        private const val REGEX_PATTERN = "$CUSTOM_DELIMITER_PREFIX(.*)$CUSTOM_DELIMITER_SUFFIX(.*)"
        private const val EMPTY_STRING = ""
        private val regex = REGEX_PATTERN.toRegex()
    }
}
