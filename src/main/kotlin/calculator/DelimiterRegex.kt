package calculator

enum class DelimiterRegex(val regex: Regex) {
    DEFAULT("[:,]".toRegex()),
    CUSTOM("//.*\\n".toRegex());

    companion object {
        fun getDelimiterRegexes(): List<Regex> = DelimiterRegex.values().map { it.regex }
    }
}
