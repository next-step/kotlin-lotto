package calculator

class Separator {
    companion object {
        fun separate(expression: String) =
            CalculateRegex.customSeparatorRegex.find(expression)
                ?.let { customSeparator(it.groupValues[2], getCustomSeparatorRegex(it.groupValues[1])) }
                ?: defaultSeparate(expression)

        private fun defaultSeparate(expression: String) =
            expression.split(CalculateRegex.defaultSeparatorRegex)

        private fun customSeparator(expression: String, customSeparatorRegex: Regex) =
            expression.split(customSeparatorRegex)

        private fun getCustomSeparatorRegex(customSeparator: String) =
            Regex("[$CalculateRegex.DEFAULT_SEPARATOR_REGEX$customSeparator]")
    }
}
