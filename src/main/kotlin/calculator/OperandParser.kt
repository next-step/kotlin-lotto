package calculator

import calculator.utils.findByPattern

object OperandParser {
    fun run(expression: String, delimiter: List<String>): List<Int> {
        return when (delimiter.size == 2) {
            true -> parserByDefaultDelimiter(expression, delimiter)
            false -> parserByCustomDelimiter(expression, delimiter)
        }
    }

    private fun parserByDefaultDelimiter(expression: String, delimiter: List<String>): List<Int> =
        expression.split("[${delimiter.joinToString(separator = "")}]".toRegex()).map { it.toInt() }

    private fun parserByCustomDelimiter(expression: String, delimiter: List<String>): List<Int> {
        val matchResult = expression.findByPattern()
        matchResult?.let { result ->
            return result.groupValues[2]
                .split(delimiter.first())
                .map { it.toInt() }
        } ?: run { return emptyList() }
    }
}
