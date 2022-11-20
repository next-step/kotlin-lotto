import utils.findByPattern

object OperandParser {
    fun run(expression: String, delimiter: String?): List<Int> {
        return when (delimiter) {
            null -> parserByDefaultDelimiter(expression)
            else -> parserByCustomDelimiter(expression, delimiter)
        }
    }

    private fun parserByDefaultDelimiter(expression: String): List<Int> =
        expression.split("[,:]".toRegex()).map { it.toInt() }

    private fun parserByCustomDelimiter(expression: String, delimiter: String): List<Int> {
        val matchResult = expression.findByPattern()
        matchResult?.let { result ->
            return result.groupValues[2]
                .split(delimiter)
                .map { it.toInt() }
        } ?: run { return emptyList() }
    }
}
