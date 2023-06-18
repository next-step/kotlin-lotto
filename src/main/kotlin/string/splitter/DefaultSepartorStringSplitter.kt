package string.splitter

import string.converter.ExpressionTokenConverter

class DefaultSeparatorStringSplitter(
    private val converter: ExpressionTokenConverter
) : SeparatorStringSplitter {
    override fun split(input: String): List<Int>? {
        val singleNumeric = parseSingleNumeric(input)
        if (singleNumeric != null) {
            return listOf(singleNumeric)
        }
        return input.split(",|:".toRegex()).map { converter.convert(it) }
    }

    private fun parseSingleNumeric(expression: String) = runCatching {
            converter.convert(expression)
    }.getOrNull()
}