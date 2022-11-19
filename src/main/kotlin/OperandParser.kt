import utils.findPattern

object OperandParser {
    fun run(expression: String, delimiter: String?): List<String> {
        return when (delimiter) {
            null -> parserByDefaultDelimiter(expression)
            else -> parserByCustomDelimiter(expression, delimiter)
        }
    }

    private fun parserByDefaultDelimiter(expression: String): List<String> =
        expression.split(",|:".toRegex())

    private fun parserByCustomDelimiter(expression: String, delimiter: String): List<String> =
        expression.findPattern()?.groupValues?.get(2)?.split(delimiter) ?: emptyList()
}
