package stringcalculator

import stringcalculator.StringParser.splitWithDefault

data class Delimiter(
    private var value: String? = null,
) {
    private val delimiters: List<String> = value?.parseDelimiter()
        ?.let { DEFAULT_DELIMITERS + it }
        ?: DEFAULT_DELIMITERS

    val regex: Regex = delimiters.joinToString(DEFAULT_SEPARATOR).toRegex()

    private fun String.parseDelimiter(): String? {
        val delimiter = this.splitWithDefault(StringParser.줄바꿈).first()

        return delimiter.drop(DROP_SIZE)
            .takeIf { it.isNotEmpty() }
    }

    companion object {
        private val DEFAULT_DELIMITERS = listOf(":", ",")
        private const val DEFAULT_SEPARATOR = "|"
        private const val DROP_SIZE = 2
    }
}
