package calculator

import java.util.regex.Matcher
import java.util.regex.Pattern

object StringAddCalculator {
    private const val COMMA_DELIMITER = ","
    private const val COLONS_DELIMITER = ":"
    private const val CUSTOM_SPLIT_PATTERN = "^//(.)\n(.*)"

    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        val tokens = splitTokens(input).map { it.toInt() }
        if (tokens.any { it < 0 }) throw RuntimeException("0 이상의 숫자를 입력해주세요.")

        return tokens.sum()
    }

    private fun splitTokens(input: String): List<String> {
        val matcher: Matcher = Pattern.compile(CUSTOM_SPLIT_PATTERN).matcher(input)
        val hasCustomDelimiter = matcher.find()
        return if (hasCustomDelimiter) {
            val delimiter = matcher.group(1)
            val inputs = matcher.group(2)
            inputs.split(delimiter)
        } else {
            input.split(COMMA_DELIMITER, COLONS_DELIMITER)
        }
    }
}
