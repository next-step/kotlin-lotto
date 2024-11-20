package calculator

class Calculator {
    fun execute(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val result = Regex(CUSTROM_DELIMITER).find(text)

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
        return this.sum(text.split(Regex(BASIC_DELIMITER)))
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
        require((number < 0).not()) { "음수 값은 더할 수 없습니다. [$number] in $input" }
        return number
    }

    companion object {
        const val BASIC_DELIMITER = ",|:"
        const val CUSTROM_DELIMITER = "//(.)\n(.*)"
    }
}
