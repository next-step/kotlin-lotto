package stringcalculator

data class InputNumbers(
    val values: List<InputNumber>
) {

    companion object {
        const val DEFAULT_SEPARATORS = "[,:]"
        const val CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)"

        fun from(text: String): InputNumbers {
            val (separator, tokens) = Regex(CUSTOM_SEPARATOR_REGEX).find(text)?.let {
                it.groupValues[1] to it.groupValues[2]
            } ?: (DEFAULT_SEPARATORS to text)

            return InputNumbers(
                tokens.split(separator.toRegex()).map {
                    InputNumber(it)
                }
            )
        }
    }
}
