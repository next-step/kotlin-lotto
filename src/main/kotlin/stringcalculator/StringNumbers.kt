package stringcalculator

data class StringNumbers(private val text: String?) {
    var list: List<Int>
        private set

    init {
        list = when {
            text.isNullOrBlank() -> listOf(0)
            Regex(REGEX_CUSTOM_DELIMITER).matches(text) -> parserInt(splitCustomDelimiter(text))
            else -> {
                parserInt(splitDefaultDelimiter(text))
            }
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
        val result = Regex(REGEX_CUSTOM_DELIMITER).find(text) ?: throw IllegalArgumentException("검증된 패턴입니다.")
        return result.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        }
    }

    private fun String.isInt(): Boolean = this.toIntOrNull() != null

    companion object {
        const val REGEX_DEFAULT_DELIMITERS = "[,:]"
        const val REGEX_CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
