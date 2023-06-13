package string.add.calculator

class StringAddCalculator {
    private val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

    fun add(text: String?): Int {
        return calculateOrDefault(text)
    }

    private fun calculateOrDefault(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        if (text.isBlank()) {
            return 0
        }

        return calculate(text)
    }

    private fun calculate(text: String): Int {
        var newText = text

        findCustomDelimiter(newText)?.let {
            delimiters.add(it)
            newText = newText.substringAfter(CUSTOM_DELIMITER_END)
        }

        val numberStrings = newText.split(*delimiters.toTypedArray())

        val numbers = convertToIntList(numberStrings)
        return numbers.sum()
    }

    private fun findCustomDelimiter(text: String): String? {
        val result = Regex("//(.)\n(.*)").find(text)
        return result?.groupValues?.get(1)
    }

    private fun convertToIntList(numberStrings: List<String>): List<Int> {
        val numbers = numberStrings.map { it.toIntOrNull() ?: throw RuntimeException("숫자 이외의 값이 전달되었습니다.") }

        validateNumbers(numbers)
        return numbers
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수가 전달되었습니다.")
        }
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA: String = ","
        private const val DEFAULT_DELIMITER_COLON: String = ":"
        private const val CUSTOM_DELIMITER_END: String = "\n"
    }
}
