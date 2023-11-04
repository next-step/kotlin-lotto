package calculator

object StringAddCalculator {

    private val DELIMITER = listOf(",", ":")
    private val parsingPatternRegex = Regex("//(.)\n(.*)")

    fun sum(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        val patternToken = parseInputPattern(input)
        val delimiter = getDelimitersRegex(patternToken.customDelimiter)
        val numbers = split(patternToken.addStringPattern, delimiter)
        if (hasNegative(numbers)) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
        return sumAll(numbers)
    }

    private fun parseInputPattern(input: String): PatternToken {
        val result = parsingPatternRegex.find(input)
        return PatternToken(
            result?.groupValues?.get(2) ?: input,
            result?.groupValues?.get(1)
        )
    }

    private fun getDelimitersRegex(customDelimiter: String?): Regex {
        val delimiters = DELIMITER + (customDelimiter ?: "")
        return delimiters.joinToString("", "[", "]").toRegex()
    }

    private fun split(addString: String, delimiter: Regex): List<String> {
        return addString.split(delimiter)
    }

    private fun sumAll(numbers: List<String>): Int {
        return numbers.sumOf { it.toInt() }
    }

    private fun hasNegative(numbers: List<String>): Boolean {
        return numbers.any { it.toInt() < 0 }
    }
}
