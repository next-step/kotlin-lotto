package calculator.domain

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val regexResult = Regex(REGEX_PATTERN).find(text)
        val customSeparator = regexResult?.let {
            it.groupValues[1]
        }
        val separators = Separators()
        separators.add(Separator(customSeparator.toString()))

        val splitData = TokenizedExpression.generate(text.substringAfter("\n"), separators)
        return splitData.mapNotNull { it.toIntOrNull() }.sum()
    }

    companion object {
        private const val REGEX_PATTERN = "//(.)\n(.*)"
    }
}
