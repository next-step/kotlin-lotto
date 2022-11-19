import utils.findPattern

object OperandParser {
    fun run(expression: String, delimiter: String?): List<Int> {
        return when (delimiter) {
            null -> parserByDefaultDelimiter(expression)
            else -> parserByCustomDelimiter(expression, delimiter)
        }
    }

    private fun parserByDefaultDelimiter(expression: String): List<Int> =
        expression.split("[,:]".toRegex()).map { it.toInt() }

    private fun parserByCustomDelimiter(expression: String, delimiter: String): List<Int> =
        expression.findPattern()?.groupValues?.get(2)?.split(delimiter)?.map { it.toInt() } ?: emptyList()
}
