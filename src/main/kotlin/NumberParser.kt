class NumberParser {
    fun parseNumbers(text: String?): List<Int> =
        if (text.isNullOrBlank()) {
            listOf(0)
        } else {
            text.split(DELIMITER.joinToString(separator = REGULAR_EXPRESSION_OR).toRegex()).map { it.toInt() }
        }

    companion object {
        private val DELIMITER = listOf(',', ':')
        private const val REGULAR_EXPRESSION_OR = "|"
    }
}
