class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        var numberList = when {
            isBasicRegex(text) -> { basicCase(text) }
            isCustomRegex(text) -> { customCase(text) }
            else -> { return model.Number(text.toInt()).number }
        }
        return Calculator.sum(numberList)
    }

    private fun convertToNumber(text: String): Int {
        return text.toInt()
    }

    private fun customCase(text: String): List<model.Number> {
        val list = text.split(CUSTOM_DELIMITER)
        val delimiter = getDelimiter(list)
        val contents = getCustomDelimiterContentsList(list, delimiter)
        return contents.map { model.Number(convertToNumber(it)) }
    }

    private fun basicCase(text: String): List<model.Number> {
        val list = text.split(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
        return list.map { model.Number(convertToNumber(it)) }
    }

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
    }
}
