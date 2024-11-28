package calculator

object DelimiterConstants {
    val DEFAULT_DELIMITER_PATTERN = "[,:]".toRegex()
    const val COMMA_DELIMITER = ","
    const val COLON_DELIMITER = ":"
    const val CUSTOM_DELIMITER_GROUP_INDEX = 1
    const val NUMBERS_GROUP_INDEX = 2

    val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)".toRegex()
    val SINGLE_NUMBER_PATTERN = "\\d+".toRegex()

    const val EMPTY_STRING = ""
}
