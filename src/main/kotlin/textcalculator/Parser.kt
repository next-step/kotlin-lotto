package textcalculator

class Parser {
    fun split(text: String): List<String> {
        return text.split(Regex(REGEX_DEFAULT_DELIMITERS))
    }

    companion object {
        private const val REGEX_DEFAULT_DELIMITERS = "[:,]"
    }
}
