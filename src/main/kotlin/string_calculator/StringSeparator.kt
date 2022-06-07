package string_calculator

private val CUSTOM_LOG_REGEX = Regex("//(.)\n(.*)")

object StringSeparator {
    fun splitToDelimitersAndNumbers(text: String): Pair<Delimiters, String> {
        CUSTOM_LOG_REGEX.find(text)?.let {
            val delimiters = Delimiters.instanceOf(it.groupValues[1])
            return delimiters to it.groupValues[2]
        }

        return Delimiters.default() to text
    }
}
