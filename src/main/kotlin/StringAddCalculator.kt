class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        } else if (text.contains(BASIC_DELIMITER_COMMA) || text.contains(BASIC_DELIMITER_COLON)) {
            val list = text.split(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
            return list.sumBy { it.toInt() }
        } else if (CUSTOM_DELIMITTER_REGEX.matches(text)) {
            val list = text.split(CUSTOM_DELIMITTER)
            val delimiter = list.first().replace("//", "")
            val contents = list.last().split(delimiter)
            return contents.sumBy { it.toInt() }
        } else if (text.toInt() < 0) {
            throw RuntimeException("number is must positive")
        } else {
            return text.toInt()
        }
        return 1
    }

    companion object {
        const val BASIC_DELIMITER_COMMA = ","
        const val BASIC_DELIMITER_COLON = ":"
        const val CUSTOM_DELIMITTER = "\n"
        val CUSTOM_DELIMITTER_REGEX = Regex(pattern = "//.\n.*")
    }
}
