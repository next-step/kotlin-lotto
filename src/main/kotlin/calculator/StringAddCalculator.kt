package calculator

import calculator.Parser.parse

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return RETURN_VALUE
        }

        val tokens = parse(text)
        return tokens.sum()
    }

    companion object {
        val PARSER_RULE = Regex("//(.)\n(.*)")
        val STD_DELIMITER = Regex("[,:]")
        const val RETURN_VALUE = 0
    }
}
