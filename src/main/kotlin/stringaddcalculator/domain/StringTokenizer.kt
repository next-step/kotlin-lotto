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
            ?: return null to input
        return matchResult.groupValues[1] to matchResult.groupValues[2]
    }

    companion object {
        private val CUSTOM_REGEX = "//(.)\n(.*)".toRegex()
    }
}
