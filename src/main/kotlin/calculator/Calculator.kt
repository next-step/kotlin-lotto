package calculator

class Calculator {
    fun execute(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val result = CUSTOM_DELIMITER_REGEX.find(text)

        return result?.let {
            this.handleCustomDelimiter(result)
        } ?: run {
            this.handleBasicDelimiter(text)
        }
    }

    private fun sum(input: List<String>): Int {
        return input.sumOf {
            this.convertToNumber(it)
        }
    }

    private fun handleBasicDelimiter(text: String): Int {
        return this.sum(text.split(BASIC_DELIMITER_REGEX))
    }

    private fun handleCustomDelimiter(result: MatchResult): Int {
        val customDelimiter = result.groupValues[1]
        val numbers = result.groupValues[2]
        return this.sum(numbers.split(customDelimiter))
    }

    private fun convertToNumber(input: String): Int {
        val number =
            input.toIntOrNull()
                ?: throw RuntimeException("숫자 이외의 값은 더할 수 없습니다. [$input]")
        require((number >= 0)) { "음수 값은 더할 수 없습니다. [$number] in $input" }
        return number
    }

    companion object {
        private const val BASIC_DELIMITER = ",|:"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
        private val BASIC_DELIMITER_REGEX = Regex(BASIC_DELIMITER)
        private val CUSTOM_DELIMITER_REGEX = Regex(CUSTOM_DELIMITER)
    }
}
