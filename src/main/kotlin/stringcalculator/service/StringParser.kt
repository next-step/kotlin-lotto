package stringcalculator.service

import stringcalculator.model.PositiveNumber
import kotlin.text.RegexOption.DOT_MATCHES_ALL

object StringParser {
    val DEFAULT_DELIMITER = Regex("""[,:]""")

    val CUSTOM_DELIMITED_TEXT_REGEX = Regex("""^//(.+)\n(.*)$""", DOT_MATCHES_ALL)

    fun convertToList(input: String): List<PositiveNumber> {
        if (input.matches(CUSTOM_DELIMITED_TEXT_REGEX)) {
            val matchResult = CUSTOM_DELIMITED_TEXT_REGEX.find(input)!!
            val (delimiter, delimitedBody) = matchResult.destructured
            return delimitedBody.split(delimiter).map { PositiveNumber.of(it) }
        }

        return input.split(DEFAULT_DELIMITER).map { PositiveNumber.of(it) }
    }
}
