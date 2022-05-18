package stringcalculator.domain

class Separator(addedSeparators: List<String>) {
    var separators: MutableList<String> = COMMON_SEPARATOR.toMutableList()
        private set

    init {
        addedSeparators.forEach { separator: String -> addSeparator(separator) }
    }

    private fun addSeparator(separator: String) {
        if (separators.contains(separator)) return
        separators.add(separator)
    }

    companion object {
        private const val CUSTOM_SEPARATOR_START = "//"
        private const val CUSTOM_SEPARATOR_END = "\n"
        private val COMMON_SEPARATOR: List<String> = listOf(":", ",")

        fun getCustomSeparator(customSeparatorString: String): String {
            return customSeparatorString.substring(
                customSeparatorString.indexOf(CUSTOM_SEPARATOR_START) + CUSTOM_SEPARATOR_START.length,
                getCustomSeparatorEndIndexWithSepartorSize(customSeparatorString)
            )
        }

        fun hasCustomSeparator(expression: String): Boolean {
            return hasCustomSeparatorStatString(expression) && hasCustomSeparatorEndString(expression)
        }

        fun getCustomString(expression: String) =
            expression.slice(0..getCustomSeparatorEndIndexWithSepartor(expression))

        private fun getCustomSeparatorEndIndexWithSepartor(expression: String) =
            expression.indexOf(CUSTOM_SEPARATOR_END)

        fun getCustomSeparatorEndIndexWithSepartorSize(expression: String) =
            expression.indexOf(CUSTOM_SEPARATOR_END) + CUSTOM_SEPARATOR_END.length

        private fun hasCustomSeparatorEndString(expression: String) = expression.contains(CUSTOM_SEPARATOR_END)

        private fun hasCustomSeparatorStatString(expression: String) =
            expression.substring(0, CUSTOM_SEPARATOR_START.length) == CUSTOM_SEPARATOR_START
    }
}
