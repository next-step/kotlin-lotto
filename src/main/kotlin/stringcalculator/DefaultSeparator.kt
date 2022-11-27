package stringcalculator

object DefaultSeparator {

    private const val DEFAULT_SEPARATORS = "[,:]"
    private const val CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)"

    fun separate(input: String): List<String> {
        val result = Regex(CUSTOM_SEPARATOR_REGEX).find(input)
        val (separator, tokens) = result?.let {
            it.groupValues[1] to it.groupValues[2]
        } ?: (DEFAULT_SEPARATORS to input)
        val regex = separator.toRegex()

        return tokens.split(regex = regex)
    }
}
