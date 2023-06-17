package stringcalculator.parser

import stringcalculator.Operand

object RegexExpressionParser : ExpressionParser {

    private val DEFAULT_DELIMITERS = listOf(",", ":")
    private val REGEX = """//(.)\\n(.*)""".toRegex()

    override fun getOperands(input: String): List<Operand> {
        val (delimiter, finalInput) = splitCustomDelimiter(input)
        val finalDelimiters = delimiter?.let { listOf(it) + DEFAULT_DELIMITERS } ?: DEFAULT_DELIMITERS
        return extractOperands(finalDelimiters, finalInput)
    }

    private fun splitCustomDelimiter(input: String): Pair<String?, String> {
        val matchResult = REGEX.find(input)
        if (matchResult !== null) {
            val (delimiter, finalInput) = matchResult.destructured
            return delimiter to finalInput
        }
        return null to input
    }

    private fun extractOperands(delimiters: List<String>, input: String): List<Operand> {
        return input.split(*delimiters.toTypedArray())
            .map { Operand.of(it) }
    }
}
