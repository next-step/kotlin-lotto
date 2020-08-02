package calculator

class Calculator {
    companion object {
        val CUSTOM_DELIMITER_REGEX = Regex("^//(.)\n(.*)")
        val INTEGER_REGEX = Regex("\\d")
        const val COMMA_DELIMITER = ","
        const val COLON_DELIMITER = ":"
        const val SLASH = "//"
        const val NEWLINE = "\n"
    }

    fun add(value: String): Int {
        when {
            value.isBlank() -> return 0
            value.matches(INTEGER_REGEX) -> return value.toInt()
        }

        val numberList: List<Int> = when (findCustomDelimiter(value)) {
            true -> getNumbersByCustomDelimiter(value)
            false -> value.split(COLON_DELIMITER, COMMA_DELIMITER).map(String::toInt)
        }

        validateNegative(numberList)

        return numberList.sum()
    }

    private fun validateNegative(numberList: List<Int>) {
        if (numberList.any { it < 0 }) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }

    private fun getNumbersByCustomDelimiter(value: String): List<Int> {
        val splitResult = value.split(SLASH, NEWLINE)
        val customDelimiter = splitResult[1]
        return splitResult[2].split(customDelimiter).map(String::toInt)
    }

    private fun findCustomDelimiter(value: String): Boolean {
        return value.contains(CUSTOM_DELIMITER_REGEX)
    }
}
