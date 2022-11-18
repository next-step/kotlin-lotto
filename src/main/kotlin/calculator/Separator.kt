package calculator

class Separator {
    companion object {
        private const val DEFAULT_SEPARATOR_REGEX = ",|:"
        private const val CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)"

        fun separate(expression: String) =
            Regex(CUSTOM_SEPARATOR_REGEX).find(expression)
                ?.let { customSeparator(it.groupValues[2], getCustomSeparatorRegex(it.groupValues[1])) }
                ?: defaultSeparate(expression)

        private fun defaultSeparate(expression: String) =
            expression.split(Regex("[$DEFAULT_SEPARATOR_REGEX]"))

        private fun customSeparator(expression: String, customSeparatorRegex: String) =
            expression.split(Regex("[$customSeparatorRegex]"))

        private fun getCustomSeparatorRegex(customSeparator: String) = DEFAULT_SEPARATOR_REGEX + customSeparator
    }
}
