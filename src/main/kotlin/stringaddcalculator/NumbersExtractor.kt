package stringaddcalculator

object NumbersExtractor {
    private val DEFAULT_DELIMITER_REGEX = Regex("[,:]")
    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\\n(.*)")

    fun extract(text: String): List<Int> {
        val splitNumbers = splitToNumbers(text)
        return splitNumbers.map { splitNumber ->
            splitNumber.toInt()
        }
    }

    private fun splitToNumbers(text: String): List<String> {
        return if (text.contains(CUSTOM_DELIMITER_REGEX)) {
            val matchResult = CUSTOM_DELIMITER_REGEX.find(text) ?: return emptyList()

            val delimiter = matchResult.groupValues[1]
            matchResult.groupValues[2].split(delimiter)
        } else {
            text.split(DEFAULT_DELIMITER_REGEX)
        }
    }
}