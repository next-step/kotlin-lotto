package step1

private const val DEFAULT_DELIMITERS = ",|:"
private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val NEW_LINE = "\\n"

object Calculator {
    fun sum(expression: String): Int {
        val numbers: List<Int>

        if (expression.startsWith(CUSTOM_DELIMITER_PREFIX) && expression.contains(NEW_LINE)) {
            numbers = convertToInt(customSplit(expression), customSeparator(expression))
        } else {
            numbers = convertToInt(expression, DEFAULT_DELIMITERS)
        }

        return calculate(numbers)
    }

    private fun customSeparator(expression: String): String {
        val startIndex = expression.indexOf(CUSTOM_DELIMITER_PREFIX) + 2
        val endIndex = expression.indexOf(NEW_LINE)

        return expression.substring(startIndex, endIndex)
    }

    private fun customSplit(expression: String): String {
        val endIndex = expression.indexOf(NEW_LINE)

        return expression.substring(endIndex + 2)
    }

    private fun convertToInt(data: String, delimiters: String): List<Int> {
        val splitNumbers = data.split(Regex(delimiters))

        return splitNumbers
            .filter { it.isNotEmpty() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값: $it") }
    }

    private fun calculate(numbers: List<Int>): Int {
        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("음수는 입력할 수 없습니다.")
        }

        return numbers.sum()
    }
}
