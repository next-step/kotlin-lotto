package calculator

class Calculator {
    fun add(value: String?): Int {
        if (value.isNullOrBlank()) return 0
        if (value.toIntOrNull() != null) return value.toInt()
        val matchResult = CUSTOM_DELIMITER_REGEX.find(value)
        if (matchResult != null) {
            val (delimiter, expression) = matchResult.destructured
            return expression
                .split(*DEFAULT_DELIMITERS, delimiter)
                .sumOf { it.toInt() }
        }
        return value
            .split(*DEFAULT_DELIMITERS)
            .sumOf { it.toInt() }
    }

    companion object {
        val DEFAULT_DELIMITERS = arrayOf(",", ":")
        val CUSTOM_DELIMITER_REGEX = Regex("//(.+)\\n(.+)")
    }
}

