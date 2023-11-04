package calculator

object Parser {
    private const val COMMA_OR_COLON = "[,|:]"
    private const val DOUBLE_SLASH = "//"
    private const val NEW_LINE = "\n"
    private val customDelimiterRegex = Regex("${DOUBLE_SLASH}(.)${NEW_LINE}(.*)")

    fun parse(text: String): PositiveNumberList {
        val match = customDelimiterRegex.find(text)

        val stringList = match?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: run {
            text.split(COMMA_OR_COLON.toRegex())
        }

        return PositiveNumberList(stringList.map { PositiveNumber(it) })
    }
}
