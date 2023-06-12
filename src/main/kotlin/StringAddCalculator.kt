object StringAddCalculator {
    private const val CUSTOM_DELIMITER_FIND_REGEX = "//(.)\n(.*)"
    private const val DEFAULT_DELIMITERS_REGEX = "[,:]"

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val matchResult = Regex(CUSTOM_DELIMITER_FIND_REGEX).find(text)
        matchResult?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return sum(tokens)
        }

        val delimiter = DEFAULT_DELIMITERS_REGEX.toRegex()
        val tokens = text.split(delimiter)
        return sum(tokens)
    }

    private fun sum(tokens: List<String>): Int {
        require(tokens.all { it.toInt() >= 0 }) { "음수는 입력할 수 없습니다." }
        return tokens.sumOf { it.toInt() }
    }
}
