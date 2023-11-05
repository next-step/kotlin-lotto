package calculator

import calculator.Parser.parse

object StringAddCalculator {
    val PARSER_RULE = Regex("//(.)\n(.*)")
    val STD_DELIMITER = Regex("[,:]")
    private const val RETURN_VALUE = 0

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return RETURN_VALUE
        }

        val tokens = parse(text)
        return tokens.sum()
    }
}
