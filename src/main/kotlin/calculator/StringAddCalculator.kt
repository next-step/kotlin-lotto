package calculator

class StringAddCalculator(text: String?) {
    private var numbers = listOf(Number("0"))
    private var result: MatchResult? = null

    init {
        if (!text.isNullOrBlank()) {
            result = Regex("//(.)\n(.*)").find(text)
            makeNumList(text)
        }
    }

    fun sum(): Int {
        return numbers.map { it.number }.sum()
    }

    private fun makeNumList(text: String) {
        result?.let {
            val custom = it.groupValues[1]
            numbers = toNumberList(splitDelimiter(it.groupValues[2], custom))
        } ?: {
            numbers = toNumberList(splitDelimiter(text))
        }()
    }

    private fun splitDelimiter(string: String, custom: String = ","): List<String> {
        return string.split(COMMA, COLON, custom).map { it.trim() }
    }

    private fun toNumberList(list: List<String>): List<Number> {
        return list.map { Number(it) }
    }

    companion object {
        const val COMMA: String = ","
        const val COLON: String = ":"
    }
}
