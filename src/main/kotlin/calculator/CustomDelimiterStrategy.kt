package calculator

import calculator.DelimiterConstants.CUSTOM_DELIMITER_GROUP_INDEX
import calculator.DelimiterConstants.NUMBERS_GROUP_INDEX

class CustomDelimiterStrategy : DelimiterStrategy {
    override fun supports(text: String): Boolean {
        return DelimiterConstants.CUSTOM_DELIMITER_PATTERN.matches(text)
    }

    override fun parse(text: String): List<Int> {
        return DelimiterConstants.CUSTOM_DELIMITER_PATTERN.find(text)?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[CUSTOM_DELIMITER_GROUP_INDEX]
            val numbers = matchResult.groupValues[NUMBERS_GROUP_INDEX]

            numbers.split(customDelimiter)
                .map { it.trim() }
                .filter { it != DelimiterConstants.EMPTY_STRING }
                .map { it.toInt() }
        } ?: emptyList()
    }
}
