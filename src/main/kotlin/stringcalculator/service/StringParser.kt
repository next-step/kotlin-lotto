package stringcalculator.service

import stringcalculator.model.PositiveNumbers

object StringParser {
    val DEFAULT_DELIMITER = Regex("""[,:]""")
    val CUSTOM_DELIMITED_TEXT_REGEX = Regex("""^//(.+)\\n(.*)$""")

    fun convertToList(input: String): PositiveNumbers {
        val strings = CUSTOM_DELIMITED_TEXT_REGEX.find(input)
            ?.destructured?.run { split(component1(), component2()) }
            ?: split(DEFAULT_DELIMITER, input)

        return PositiveNumbers.of(strings)
    }

    private fun split(delimiter: Regex, delimitedBody: String): List<String> {
        return delimitedBody.split(delimiter)
    }

    private fun split(delimiter: String, delimitedBody: String): List<String> {
        return delimitedBody.split(delimiter)
    }
}
