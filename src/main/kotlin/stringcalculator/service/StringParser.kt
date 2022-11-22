package stringcalculator.service

import stringcalculator.model.PositiveNumber
import kotlin.text.RegexOption.DOT_MATCHES_ALL

object StringParser {
    val DEFAULT_DELIMITER = Regex("""[,:]""")

    val CUSTOM_DELIMITED_TEXT_REGEX = Regex("""^//(.+)\n(.*)$""", DOT_MATCHES_ALL)

    private const val CUSTOM_DELIMITER_GROUP_INDEX = 1
    private const val CUSTOM_DELIMITED_BODY_GROUP_INDEX = 2

    fun convertToList(input: String): List<PositiveNumber> {
        if (input.matches(CUSTOM_DELIMITED_TEXT_REGEX)) {
            val result = CUSTOM_DELIMITED_TEXT_REGEX.find(input)!!
            val delimiter = result.groupValues[CUSTOM_DELIMITER_GROUP_INDEX]
            val delimitedBody = result.groupValues[CUSTOM_DELIMITED_BODY_GROUP_INDEX]
            return delimitedBody.split(delimiter).map { PositiveNumber.of(it) }
        }

        return input.split(DEFAULT_DELIMITER).map { PositiveNumber.of(it) }
    }
}
