package calculator

object StringParser {

    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    private const val FIXED_DELIMITERS = ",:"

    fun parse(source: String): List<PositiveNumber> {
        if (source.isBlank()) {
            return emptyList()
        }

        val matchedGroupValues = CUSTOM_DELIMITER_REGEX.find(source)?.groupValues
        val separationRegex = run {
            val customDelimiter = matchedGroupValues?.getOrNull(1)
            val finalDelimiters = if (customDelimiter == null) {
                FIXED_DELIMITERS
            } else {
                FIXED_DELIMITERS.plus(customDelimiter)
            }
            Regex("[$finalDelimiters]")
        }
        val calculationTargetText = run {
            val delimitedText = matchedGroupValues?.getOrNull(2)
            delimitedText ?: source
        }
        return calculationTargetText
            .split(separationRegex)
            .map { maybeNumber -> PositiveNumber.of(maybeNumber) }
    }
}
