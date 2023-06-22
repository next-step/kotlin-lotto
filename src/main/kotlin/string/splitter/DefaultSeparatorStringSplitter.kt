package string.splitter

import string.converter.ExpressionTokenConverter

class DefaultSeparatorStringSplitter(
    private val converter: ExpressionTokenConverter,
) : SeparatorStringSplitter {
    override fun split(input: String): List<Int>? {
        val singleNumeric = parseSingleNumeric(input)
        if (singleNumeric != null) {
            return listOf(singleNumeric)
        }
        return input.split(separatorRegex).map { converter.convert(it) }
    }

    private fun parseSingleNumeric(expression: String) = runCatching {
        converter.convert(expression)
    }.getOrNull()

    companion object {
        private const val COMMA_OR_COLON = ",|:"
        private val separatorRegex = COMMA_OR_COLON.toRegex()
    }
}
