package string

import string.converter.ExpressionTokenConverter

class DefaultSeparatorStringSplitter(
    private val converter: ExpressionTokenConverter
) : SeparatorStringSplitter {
    override fun split(input: String): List<Int>? {
        val singleNumeric = parseSingleNumeric(input)
        if (singleNumeric != null) {
            return listOf(singleNumeric)
        }

        val delimiter = when {
            input.contains(',') -> ","
            input.contains(':') -> ":"
            else -> return null
        }
        return input.split(delimiter).map { converter.convert(it) }
    }

    private fun parseSingleNumeric(expression: String) = runCatching {
            converter.convert(expression)
    }.getOrNull()
}