package stringaddcalculator

object NumbersExtractor {
    private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    private val CUSTOM_DELIMITER_REGEX = Regex("//(.*)\\n(.*)")

    fun extract(text: String): List<Int> {
        val splitNumbers = splitToNumbers(text)
        return splitNumbers.map { splitNumber ->
            splitNumber.toInt()
        }
    }

    private fun splitToNumbers(text: String): List<String> {
        return if (text.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.find(text) ?: return emptyList()

            val delimiter = matchResult.groupValues[1]
            validateDelimiter(delimiter)

            val numbersWithDelimiter = matchResult.groupValues[2]
            validatePattern(delimiter = delimiter, numbersWithDelimiter = numbersWithDelimiter)

            numbersWithDelimiter.split(delimiter)
        } else {
            validatePattern(delimiter = DEFAULT_DELIMITER_REGEX.pattern, numbersWithDelimiter = text)
            text.split(DEFAULT_DELIMITER_REGEX)
        }
    }

    private fun validateDelimiter(delimiter: String) {
        if (delimiter.isEmpty() || delimiter.length > 1) {
            throw IllegalArgumentException("구분자는 빈 값이거나 2글자 이상일 수 없습니다.")
        }
    }

    private fun validatePattern(delimiter: String, numbersWithDelimiter: String) {
        val patternRegex = Regex("^\\d+([${delimiter}]\\d+)+$")
        if (patternRegex.matches(numbersWithDelimiter).not()) {
            throw IllegalArgumentException("{숫자}{구분자}{숫자} 형태로 입력해야 합니다. 현재 입력 = $numbersWithDelimiter")
        }
    }
}