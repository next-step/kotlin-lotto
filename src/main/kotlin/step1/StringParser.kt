package step1

private const val CUSTOM_SEPARATOR_FIND_REGEX = "//(.)\n(.*)"
private val DEFAULT_SEPARATOR = "[,:]".toRegex()

class StringParser {

    companion object {
        fun splitBySeparator(input: String) = Regex(CUSTOM_SEPARATOR_FIND_REGEX).find(input)
            ?.let {
                val customDelimiter = it.groupValues[1]
                it.groupValues[2].split(customDelimiter)
            } ?: input.split(DEFAULT_SEPARATOR)
    }
}
