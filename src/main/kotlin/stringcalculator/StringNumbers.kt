package stringcalculator

class StringNumbers(text: String?) {
    var list: List<Int>
        private set

    init {
        list = when {
            text.isNullOrBlank() -> listOf(0)
            matchesCustomDelimiter(text) -> parserInt(splitCustomDelimiter(text))
            else -> parserInt(splitDefaultDelimiter(text))
        }
    }

    private fun splitDefaultDelimiter(value: String): List<String> = value.split(REGEX_DEFAULT_DELIMITERS.toRegex())

    private fun parserInt(list: List<String>): List<Int> {
        return list.map { strNum ->
            require(strNum.isInt()) { "숫자 이외의 값은 입력 받을 수 없습니다." }
            require(strNum.toInt() >= 0) { "음수는 입력 받을 수 없습니다." }
            strNum.toInt()
        }
    }

    private fun splitCustomDelimiter(text: String): List<String> {
        val result = findCustomDelimiter(text) ?: throw IllegalArgumentException("구분자가 포함되어 있지 않습니다.")
        return result.let {
            val (customDelimiter, numberText) = it.destructured
            numberText.split(customDelimiter)
        }
    }

    private fun String.isInt(): Boolean = this.toIntOrNull() != null

    companion object {
        const val REGEX_DEFAULT_DELIMITERS = "[,:]"
        const val REGEX_CUSTOM_DELIMITER = "//(.)\n(.*)"
        fun matchesCustomDelimiter(text: String) = Regex(REGEX_CUSTOM_DELIMITER).matches(text)
        fun findCustomDelimiter(text: String) = Regex(REGEX_CUSTOM_DELIMITER).find(text)
    }
}
