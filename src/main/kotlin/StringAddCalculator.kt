import java.lang.RuntimeException

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        if (text.contains(BASIC_DELIMITER_COMMA) || text.contains(BASIC_DELIMITER_COLON)) {
            val list = text.split(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
            return list.sumBy { it.toInt() }
        } else if (CUSTOM_DELIMITTER_REGEX.matches(text)) {
            val list = text.split(CUSTOM_DELIMITTER)
            val delimiter = list.first().replace("//", "")
            val contents = list.last().split(delimiter)
            return contents.sumBy { it.toInt() }
        } else if (NUMBER_REGEX.matches(text) && text.toInt() > 0) {
            return text.toInt()
        } else {
            throw RuntimeException()
        }
        return 1
    }

    companion object {
        const val BASIC_DELIMITER_COMMA = ","
        const val BASIC_DELIMITER_COLON = ":"
        const val CUSTOM_DELIMITTER = "\n"
        val CUSTOM_DELIMITTER_REGEX = Regex(pattern = "//.\n.*")
        val NUMBER_REGEX = Regex(pattern = "^-?[0-9]\\d*(\\.\\d+)?\$")
    }
}
