package calculator

import java.util.regex.Pattern

private val TO_REGEX: Pattern = Pattern.compile(",|:")
private val CUSTOM_DELIMITER_REGEX: Pattern = Pattern.compile("//(.)\n(.*)")

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        val (delimiter, realText) = fetchCustomDelimiter(text)

        return realText.split(delimiter)
            .map { toInt(it) }
            .sumOf { it }
    }

    private fun toInt(number: String): Int {
        if (number.toInt() < 0) {
            throw RuntimeException()
        }
        return number.toInt()
    }

    private fun fetchCustomDelimiter(text: String): CustomDelimiter {
        val matcher = CUSTOM_DELIMITER_REGEX.matcher(text)
        if (matcher.find()) {
            return CustomDelimiter(Pattern.compile(matcher.group(1)), matcher.group(2))
        }
        return CustomDelimiter(TO_REGEX, text)
    }

    private data class CustomDelimiter(val delimiter: Pattern, val text: String)
}
