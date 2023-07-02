package stringcalculator

import stringcalculator.Delimiters.Companion.DEFAULT_DELIMITER_COLON
import stringcalculator.Delimiters.Companion.DEFAULT_DELIMITER_COMMA

object StringParser {
    private const val CUSTOM_DELIMITER_INDEX = 1
    private const val WITHOUT_CUSTOM_DELIMITER_EXPRESSION_INDEX = 2

    fun getDelimitersFromString(text: String): Delimiters {
        val matchResult = Regex(Delimiters.CUSTOM_DELIMITER_FIND_REGEX).find(text)
        matchResult?.let {
            return Delimiters(
                listOf(
                    DEFAULT_DELIMITER_COMMA,
                    DEFAULT_DELIMITER_COLON,
                    it.groupValues[CUSTOM_DELIMITER_INDEX]
                )
            )
        }
        return Delimiters()
    }

    fun deleteCustomDelimiters(text: String): String {
        val matchResult = Regex(Delimiters.CUSTOM_DELIMITER_FIND_REGEX).find(text)
        matchResult?.let {
            return it.groupValues[WITHOUT_CUSTOM_DELIMITER_EXPRESSION_INDEX]
        }
        return text
    }
}

class Delimiters(val delimiters: List<String> = listOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)) {

    fun getDelimitersRegex(): Regex {
        return delimiters.joinToString("", "[", "]").toRegex()
    }

    companion object {
        const val DEFAULT_DELIMITER_COMMA = ","
        const val DEFAULT_DELIMITER_COLON = ":"
        const val CUSTOM_DELIMITER_FIND_REGEX = "//(.*)\n(.*)"
    }
}
