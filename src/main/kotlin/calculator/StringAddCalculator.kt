package calculator

object StringAddCalculator {
    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (isNumber(text)) {
            return text.toInt()
        }

        val customDelimiter = findCustomDelimiter(text)
        val tokens = parseTokens(text, customDelimiter)
        return tokens.sum()
    }

    private fun parseTokens(text: String, customDelimiter: String): List<Int> {
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
