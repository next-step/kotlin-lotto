package stringcalculator

data class StringNumbers(private val text: String?) {
    lateinit var list: List<Int>
        private set

    init {
        if (text.isNullOrEmpty() || text.isNullOrBlank()) {
            list = listOf(0)
        }
    }
    init {
        require(!text.isNullOrBlank())
        val splitStr = split(text.replace(" ", ""))
        list = parserInt(splitStr)
    }

    private fun split(value: String): List<String> = value.split(REGEX_DELIMITERS.toRegex())

    private fun parserInt(list: List<String>): List<Int> {
        return list.map { strNum ->
            check(isNumber(strNum)){"숫자 이외의 값은 입력 받을 수 없습니다."}
            check(strNum.toInt() >= 0).runCatching{ "음수는 입력 받을 수 없습니다."}
            strNum.toInt()
        }
    }

    private fun isNumber(str: String): Boolean {
        return try {
            str.toInt()
            true
        } catch (ex: NumberFormatException) {
            false
        }
    }

    private fun splitCustomDelimiter(text: String):List<String>? {
        val result = Regex("//(.)\n(.*)").find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        }
    }

    companion object {
        const val REGEX_DELIMITERS = ",|:"
    }
}
