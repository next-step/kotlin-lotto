package calculator.domain

@JvmInline
value class Separator(
    val separator: String
) {
    companion object {
        private const val REGEX_PATTERN = "//(.)\n(.*)"

        fun create(text: String): Separator {
            val regexResult = Regex(REGEX_PATTERN).find(text)
            val customSeparator = regexResult?.let {
                it.groupValues[1]
            }
            return Separator(customSeparator.toString())
        }
    }
}
