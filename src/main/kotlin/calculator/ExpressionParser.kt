package calculator

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

class ExpressionParser(
    private val delimiter: Delimiter
) {
    fun parse(text: String?): List<PositiveInteger> {
        val result = mutableListOf(PositiveInteger(0))

        if (!isEmptyExpression(text)) {
            val delimiters = delimiter.getDelimitersOfText(text)
            val expression = getExpressionSeperatedByDelimiters(text)

            val numberStringList = splitExpression(expression, delimiters)
            numberStringList?.map{ it -> parseNum(it) }?.map{ PositiveInteger(it) }?.let{ result.addAll(it) }
        }

        return result
    }

    @OptIn(ExperimentalContracts::class)
    private fun isEmptyExpression(text: String?): Boolean {
        contract {
            returns() implies (text != null)
        }
        return (text == null) || text.trim().isEmpty()
    }

    private fun getExpressionSeperatedByDelimiters(text: String): String? {
        val matchResult = Delimiter.CUSTOM_DELIMITER_FLAG_REGEX.find(text) ?: return text
        return matchResult.groupValues[2]
    }

    private fun splitExpression(text: String?, delimiters: List<String>): List<String>? {
        return text?.split(*delimiters.toTypedArray())
    }

    private fun parseNum(text: String): Int{
        return text.toIntOrNull() ?: throw RuntimeException()
    }
}