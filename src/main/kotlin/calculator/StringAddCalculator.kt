package calculator

import java.util.regex.Pattern

val TO_REGEX: Pattern = Pattern.compile(",|:")
val CUSTOM_DELIMITER_REGEX: Regex = Regex("//(.)\n(.*)")

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }
        
        return CUSTOM_DELIMITER_REGEX.find(text)?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
                .sumOf { it.toInt() }
        } ?: run {
            return text.split(TO_REGEX).sumOf { it.toInt() }
        }
    }
}