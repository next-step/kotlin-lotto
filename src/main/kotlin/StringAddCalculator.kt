class StringAddCalculator {
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
                convertToNumber(text)
            }
            else -> {
                throw RuntimeException()
            }
        }
    }

    private fun convertToNumber(text: String): Int {
        return text.toInt()
    }

    private fun customCase(text: String): Int {
        val list = text.split(CUSTOM_DELIMITER)
        val delimiter = getDelimiter(list)
        val contents = getCustomDelimiterContentsList(list, delimiter)
        val numberList = contents.map { model.Number(convertToNumber(it)) }
        return Calculator.sum(numberList)
    }

    private fun basicCase(text: String): Int {
        val list = text.split(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
        val numberList = list.map { model.Number(convertToNumber(it)) }
        return Calculator.sum(numberList)
    }

    private fun isPositiveNumber(text: String) = NUMBER_REGEX.matches(text) && convertToNumber(text) > 0

    private fun getCustomDelimiterContentsList(
        list: List<String>,
        delimiter: String
    ) = list.last().split(delimiter)

    private fun getDelimiter(list: List<String>) = list.first().replace("//", "")
    private fun isBasicRegex(text: String) = text.contains(BASIC_DELIMITER_COMMA) || text.contains(BASIC_DELIMITER_COLON)
    private fun isCustomRegex(text: String) = CUSTOM_DELIMITER_REGEX.matches(text)

    companion object {
        const val BASIC_DELIMITER_COMMA = ","
        const val BASIC_DELIMITER_COLON = ":"
        const val CUSTOM_DELIMITER = "\n"
        val CUSTOM_DELIMITER_REGEX = Regex(pattern = "//.\n.*")
        val NUMBER_REGEX = Regex(pattern = "^-?[0-9]\\d*(\\.\\d+)?\$")
    }
}
