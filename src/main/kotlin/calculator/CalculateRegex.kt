package calculator

object CalculateRegex {
    private const val DEFAULT_SEPARATOR_REGEX = ",|:"
    private const val CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)"
    val customSeparatorRegex = Regex(CUSTOM_SEPARATOR_REGEX)
    val defaultSeparatorRegex = Regex(DEFAULT_SEPARATOR_REGEX)
}
