package calculator

class DefaultDelimiterStrategy : DelimiterStrategy {
    override fun supports(text: String): Boolean {
        return text.contains(DelimiterConstants.COMMA_DELIMITER) ||
                text.contains(DelimiterConstants.COLON_DELIMITER)
    }

    override fun parse(text: String): List<Int> {
        return text.split(DelimiterConstants.DEFAULT_DELIMITER_PATTERN)
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
    }
}

