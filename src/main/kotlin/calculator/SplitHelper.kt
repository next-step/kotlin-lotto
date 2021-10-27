package calculator

class SplitHelper {

    private val regex = REGEX_CUSTOM.toRegex()

    fun split(input: String): List<String> {
        val matchResult = regex.find(input)

        return if (matchResult != null) {
            val (delimiter, target) = matchResult.destructured
            target.split(delimiter)
        } else {
            input.split(*DELIMITERS.toTypedArray())
        }
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private val DELIMITERS = listOf(DELIMITER_COMMA, DELIMITER_COLON)

        private const val REGEX_CUSTOM = "//(.)\n(.*)"
    }
}
