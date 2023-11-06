package calculator

import java.lang.RuntimeException

class InputParser() {
    private val defaultDelimiters = arrayOf(",", ":")
    private val customDelimiterPattern = """//(.+)\n(.*)""".toRegex()

    fun inputParse(input: String?): List<String> {
        if (input.isNullOrBlank() || input.isNullOrEmpty()) {
            return listOf("0")
        }

        val customDelimiterMatch = customDelimiterPattern.find(input)
        val delimiters = customDelimiterMatch?.groupValues?.get(1)
            ?.let { arrayOf(it) }
            ?: defaultDelimiters

        val numbers = customDelimiterMatch?.groupValues?.get(2)
            ?: input

        return splitStringWithDelimiters(numbers, delimiters)
    }

    private fun splitStringWithDelimiters(input: String, delimiters: Array<String>): List<String> {
        val regexPattern = delimiters.joinToString("|") { Regex.escape(it) }.toRegex()
        val result = input.split(regexPattern)

        for (num in result) {
            if (!isPositive(num)) {
                throw RuntimeException("숫자가 아니거나 음수는 계산할 수 없습니다.")
            }
        }

        return result
    }

    private fun isPositive(input: String): Boolean {
        return input.toIntOrNull()?.let { it >= 0 } ?: false
    }
}
