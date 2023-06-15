package calculator

@JvmInline
value class StringDelimiterSeparator(private val delimiterRegex: Regex) {

    init {
        val pattern = delimiterRegex.pattern
        require(pattern.contains("<$DELIMITER_GROUP_NAME>") and pattern.contains("<$STRINGS_GROUP_NAME>")) {
            "$DELIMITER_GROUP_NAME and $STRINGS_GROUP_NAME must be included in regex pattern." +
                " but provided pattern(`$delimiterRegex`)"
        }
    }

    infix fun split(string: String): Collection<String> {
        return delimiterRegex.find(string)
            ?.let { it.stringValue.split(it.delimiter) }
            ?: emptyList()
    }

    private val MatchResult.delimiter: String
        get() {
            return groups[DELIMITER_GROUP_NAME]?.value
                ?: throw IllegalStateException("delimiter group is not found, matchResult(`$this`), pattern(`$delimiterRegex`)")
        }

    private val MatchResult.stringValue: String
        get() {
            return groups[STRINGS_GROUP_NAME]?.value
                ?: throw IllegalStateException("strings group is not found, matchResult(`$this`), pattern(`$delimiterRegex`)")
        }

    companion object {
        private const val DELIMITER_GROUP_NAME: String = "delimiter"
        private const val STRINGS_GROUP_NAME: String = "strings"

        infix fun String.split(separator: StringDelimiterSeparator): Collection<String> {
            return separator.split(this)
        }
    }
}
