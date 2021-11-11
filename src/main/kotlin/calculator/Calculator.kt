package calculator

class Calculator {
    fun add(value: String?): Int {
        if (value.isNullOrBlank()) return 0
        val matchResult = CUSTOM_DELIMITER_REGEX.find(value)
        if (matchResult != null) {
            return calculateWithCustomDelimiter(matchResult)
        }
        return validated(value.split(*DEFAULT_DELIMITERS)).sum()
    }

    private fun calculateWithCustomDelimiter(matchResult: MatchResult): Int {
        val (delimiter, expression) = matchResult.destructured
        return validated(expression.split(*DEFAULT_DELIMITERS, delimiter)).sum()
    }

    private fun validated(numbers: List<String>): List<Int> {
        if (!numbers.map { it.toIntOrNull() }.all { it != null && it >= 0 }) {
            throw RuntimeException("음수나 숫자가 아닌 값을 입력할 수 없습니다.")
        }
        return numbers.map { it.toInt() }
    }

    companion object {
        val DEFAULT_DELIMITERS = arrayOf(",", ":")
        val CUSTOM_DELIMITER_REGEX = Regex("//(.+)\\n(.+)")
    }
}

