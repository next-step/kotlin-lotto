package calculator

class StringAddCalculator {

    fun add(text: String?): Int {
        return if (text.isNullOrBlank()) {
            0
        } else {
            text.extractPositiveNumbers().sum()
        }
    }

    private fun String.extractPositiveNumbers(): List<PositiveNumber> {
        val matchedGroupValues = CUSTOM_DELIMITER_REGEX.find(this)?.groupValues
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
            delimitedText ?: this
        }
        return calculationTargetText
            .split(separationRegex)
            .map { maybeNumber -> PositiveNumber.of(maybeNumber) }
    }
    
    companion object {
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
        private const val FIXED_DELIMITERS = ",:"
    }
}
