package calculator.model

object Tokenizer {

    private const val CUSTOM_DELIMITER_SEARCH = "//(.)\n(.*)"
    private const val DEFAULT_DELIMITER = ",|:"

    fun tokenize(input: String): Formula {
        if (input.isEmpty()) {
            return Formula.emptyOf()
        }
        Regex(CUSTOM_DELIMITER_SEARCH).find(input)?.let { matchResult ->
            val (customDelimiter, origin) = matchResult.destructured
            return Formula(splitByCustomDelimiter(customDelimiter, origin))
        }
        return Formula(splitByDefaultDelimiter(input))
    }

    private fun splitByCustomDelimiter(customDelimiter: String, origin: String): List<Int> {
        return origin
            .split(customDelimiter)
            .map { requireNumericString(it) }
    }

    private fun splitByDefaultDelimiter(input: String): List<Int> {
        return input
            .split(DEFAULT_DELIMITER.toRegex())
            .map { requireNumericString(it) }
    }

    private fun requireNumericString(input: String): Int {
        require(isNumeric(input)) { "입력된 문자열 [$input] 숫자로 변환할 수 없습니다" }
        return input.toInt()
    }

    private fun isNumeric(input: String): Boolean {
        return input.toIntOrNull() != null
    }
}
