package calculator

class StringAddCalculator {
    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.matches(Regex("[0-9]+"))) {
            return text.toInt()
        }

        val customDelimiterRegex = Regex("//(.)\n(.*)").find(text)
        val customDelimiter = customDelimiterRegex?.groupValues?.get(1) ?: ""
        val tokens = parseTokens(text, customDelimiter)

        return tokens.sum()
    }

    private fun parseTokens(text: String, customDelimiter: String): List<Int> {
        require(text.contains("-").not()) { "음수를 입력할 수 없습니다." }
        require(text.contains(Regex("[,:${customDelimiter}]"))) { "숫자와 지정된 구분자만 입력할 수 있습니다." }

        if (customDelimiter.isNotBlank()) {
            val replacedText = text.replace("//$customDelimiter\n", "")
            return replacedText.split(customDelimiter).map {
                require(it.matches(Regex("[0-9]+"))) { "숫자와 지정된 구분자만 입력할 수 있습니다." }
                it.toInt()
            }
        }


        return text.split(Regex("[,:\n]")).map {
            require(it.matches(Regex("[0-9]+"))) { "숫자와 지정된 구분자만 입력할 수 있습니다." }
            it.toInt()
        }
    }
}
