package stringaddcalculator.domain

class StringTokenizer(
    private val separators: Separators = Separators()
) {
    fun tokens(input: String): List<String> {
        val (customSeparator, source) = extract(input)
        if (customSeparator != null) {
            separators.add(customSeparator)
        }
        return source.split(separators.toRegex())
    }

    private fun extract(input: String): Pair<String?, String> {
        val matchResult = CUSTOM_REGEX.find(input)
        return matchResult?.let {
            it.groupValues[1] to it.groupValues[2]
        } ?: (null to input)
    }

    companion object {
        private val CUSTOM_REGEX = "//(.)\n(.*)".toRegex()
    }
}
