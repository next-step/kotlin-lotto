package stringsumcalculator

private val DEFAULT_DELIMITERS = listOf(",", ":")
private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")

class StringNumbers(private val text: String) : Numbers {
    override fun toList(): List<INumber> {
        val (delimiters, input) = split(text)

        val splitStrings = input.split(delimiters.joinToString("|").toRegex())

        return splitStrings.map { StringNumber(it) }
    }

    private fun split(text: String): Pair<List<String>, String> {
        return CUSTOM_DELIMITER_PATTERN.find(text)
            ?.let {
                val (customDelimiter, input) = it.destructured

                Pair(listOf(*DEFAULT_DELIMITERS.toTypedArray(), customDelimiter), input)
            }
            ?: Pair(DEFAULT_DELIMITERS, text)
    }
}
