package stringcalculator.model

object StringConverter {
    private const val CUSTOM_FORMAT = "//(.)\n(.*)"
    private val DEFAULT_DELIMITER = listOf(",", ":")
    private val regex = Regex(CUSTOM_FORMAT)

    fun splitInput(input: String): List<String> {
        val (inputString, delimiter) = getCustomString(input)
        return splitString(inputString, delimiter)
    }

    private fun getCustomString(input: String): Pair<String, List<String>> {
        val custom = regex.find(input)
        val delimiterList = custom?.groupValues?.filterIndexed { index, _ -> index == 1 } ?: DEFAULT_DELIMITER
        val customInput = custom?.groupValues?.getOrNull(2) ?: input
        return Pair(customInput, delimiterList)
    }

    private fun splitString(input: String, customDelimiter: List<String>) = input.split(*customDelimiter.toTypedArray())
}
