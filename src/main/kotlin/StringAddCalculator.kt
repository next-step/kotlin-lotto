object StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val matchResult = Regex("//(.)\n(.*)").find(text)
        matchResult?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return sum(tokens)
        }

        val delimiter = "[,:]".toRegex()
        val tokens = text.split(delimiter)
        return sum(tokens)
    }

    private fun sum(tokens: List<String>): Int {
        require(tokens.all { it.toInt() >= 0 }) { "음수는 입력할 수 없습니다." }
        return tokens.sumOf { it.toInt() }
    }
}
