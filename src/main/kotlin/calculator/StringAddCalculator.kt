package calculator

object StringAddCalculator {

    private val DELIMITER = listOf(",", ":")

    fun sum(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }
        val (addString, customDelimiter) = parseInputPattern(input)
        val delimiter = getDelimitersRegex(customDelimiter)
        val numbers = split(addString, delimiter)
        if (hasNegative(numbers)) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
        return sumAll(numbers)
    }

    private fun parseInputPattern(input: String): Pair<String, String?> {
        var addPattern: String? = null
        var customDelimiter: String? = null
        val result = Regex("//(.)\n(.*)").find(input)
        result?.let {
            customDelimiter = it.groupValues[1]
            addPattern = it.groupValues[2]
        }

        return Pair(addPattern ?: input, customDelimiter)
    }

    private fun getDelimitersRegex(customDelimiter: String?): Regex {
        val delimiters = DELIMITER + customDelimiter
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
