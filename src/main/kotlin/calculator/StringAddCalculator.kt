package calculator

import kotlin.text.MatchResult

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        if (text.length == 1) return checkInt(text)
        return sum(splitText(text))
    }

    private fun splitText(text: String): List<String> {
        val tokens = text.split(",", ":")
        val result = formatWithRegexPattern(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            tokens
        } ?: tokens
    }

    private fun sum(input: List<String>): Int {
        input.forEach { checkInt(it) }
        return input.sumOf { it.toInt() }
    }

    private fun checkInt(text: String): Int {
        require(text.toInt() > 0) {
            throw RuntimeException("양수만 입력 가능합니다.")
        }
        return text.toInt()
    }

    private fun formatWithRegexPattern(s: String): MatchResult? {
        return REGEX_PATTERN.find(s)
    }

    companion object {
        val REGEX_PATTERN = Regex("//(.)\n(.*)")
    }
}
