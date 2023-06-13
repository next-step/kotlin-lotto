package string.add.calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        if (text.isBlank()) {
            return 0
        }

        return calculate(text)
    }

    private fun calculate(text: String): Int {
        val numbers = parseNumbers(text)
        return numbers.sum()
    }

    private fun parseNumbers(text: String): List<Int> {
        var newText = text
        val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

        findCustomDelimiter(text)?.let {
            delimiters.add(it)
            newText = text.substringAfter(CUSTOM_DELIMITER_END)
        }

        val strings = newText.split(*delimiters.toTypedArray())
        val numbers = convertToIntList(strings)

        findNegativeNumber(numbers)

        return numbers
    }

    private fun convertToIntList(strings: List<String>): List<Int> {
        val result = mutableListOf<Int>()

        strings.forEach {
            try {
                val number = it.toInt()
                result.add(number)
            } catch (e: NumberFormatException) {
                throw RuntimeException("숫자 이외의 값이 전달되었습니다.")
            }
        }

        return result
    }

    private fun findNegativeNumber(numbers: List<Int>) {
        if (numbers.any { it < 0}) {
            throw RuntimeException("음수가 전달되었습니다.")
        }
    }

    private fun findCustomDelimiter(text: String): String? {
        var customDelimiter: String? = null
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            customDelimiter = it.groupValues[1]
        }
        return customDelimiter
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA: String = ","
        private const val DEFAULT_DELIMITER_COLON: String = ":"
        private const val CUSTOM_DELIMITER_END: String = "\n"
    }
}
