package calculator

class Separator {
    companion object {
        private const val DEFAULT_SEPARATOR_REGEX = ",|:"
        private const val CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)"

        private val customSeparatorRegex = Regex(CUSTOM_SEPARATOR_REGEX)
        private val defaultSeparatorRegex = Regex(DEFAULT_SEPARATOR_REGEX)

        fun separate(expression: String) =
            customSeparatorRegex.find(expression)
                ?.let { customSeparator(it.groupValues[2], getCustomSeparatorRegex(it.groupValues[1])) }
                ?: defaultSeparate(expression)

        private fun defaultSeparate(expression: String) =
            expression.split(defaultSeparatorRegex)

        private fun customSeparator(expression: String, customSeparatorRegex: Regex) =
            expression.split(customSeparatorRegex)

        private fun getCustomSeparatorRegex(customSeparator: String) = Regex("[$DEFAULT_SEPARATOR_REGEX$customSeparator]")
    }
}
