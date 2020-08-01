import java.lang.RuntimeException

class StringAddCalculator {
    private val calculator = Calculator()

    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        return when {
            isBasicRegex(text) -> {
                basicCase(text)
            }
            isCustomRegex(text) -> {
                customCase(text)
            }
            isPositiveNumber(text) -> {
                text.toInt()
            }
            else -> {
                throw RuntimeException()
            }
        }
    }

    private fun customCase(text: String): Int {
        val list = text.split(CUSTOM_DELIMITTER)
        val delimiter = getDelimiter(list)
        val contents = getCustomDelimiterContentsList(list, delimiter)
        return calculator.sum(contents)
    }

    private fun basicCase(text: String): Int {
        val list = text.split(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
        return calculator.sum(list)
    }

    private fun isPositiveNumber(text: String) = NUMBER_REGEX.matches(text) && text.toInt() > 0

    private fun getCustomDelimiterContentsList(
        list: List<String>,
        delimiter: String
    ) = list.last().split(delimiter)

    private fun getDelimiter(list: List<String>) = list.first().replace("//", "")
    private fun isBasicRegex(text: String) = text.contains(BASIC_DELIMITER_COMMA) || text.contains(BASIC_DELIMITER_COLON)
    private fun isCustomRegex(text: String) = CUSTOM_DELIMITTER_REGEX.matches(text)

    companion object {
        const val BASIC_DELIMITER_COMMA = ","
        const val BASIC_DELIMITER_COLON = ":"
        const val CUSTOM_DELIMITTER = "\n"
        val CUSTOM_DELIMITTER_REGEX = Regex(pattern = "//.\n.*")
        val NUMBER_REGEX = Regex(pattern = "^-?[0-9]\\d*(\\.\\d+)?\$")
    }
}
