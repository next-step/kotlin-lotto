package calculator

class StringParser {
    fun parseString(text: String): List<Int> {

        val customDelimiter = findCustomDelimiter(text)

        require(text.contains("-").not()) { "음수를 입력할 수 없습니다." }
        require(text.contains(Regex("[,:${customDelimiter}]"))) { "숫자와 지정된 구분자만 입력할 수 있습니다." }

        if (customDelimiter.isNotBlank()) {
            val replacedText = text.replace("//$customDelimiter\n", "")
            return replacedText.split(Regex("[,:${customDelimiter}\n]")).map {
                require(isNumber(it)) { "숫자와 지정된 구분자만 입력할 수 있습니다." }
                it.toInt()
            }
        }

        return text.split(Regex("[,:\n]")).map {
            require(isNumber(it)) { "숫자와 지정된 구분자만 입력할 수 있습니다." }
            it.toInt()
        }
    }
}