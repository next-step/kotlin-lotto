package additioncalculator.domain

class Delimiters(private val text: String) {
    init {
        require(text.isNotEmpty()) {}
    }

    fun findDelimiters(): List<String> {
        val delimiters: MutableList<String> = mutableListOf()
        if (text.contains(DEFAULT_DELIMITER)) delimiters.add(DEFAULT_DELIMITER)
        if (text.contains(SECOND_DEFAULT_DELIMITER)) delimiters.add(SECOND_DEFAULT_DELIMITER)
        val matchResult: MatchResult? = Regex(CUSTOM_DELIMITER_REGEX_PATTERN).find(text)
        matchResult?.let { delimiters.add(it.groupValues[1]) }
        return delimiters
    }

    companion object {
        const val DEFAULT_DELIMITER: String = ","
        const val SECOND_DEFAULT_DELIMITER: String = ":"
        const val CUSTOM_DELIMITER_REGEX_PATTERN: String = "//(.)\n(.*)"
    }
}
