package stringaddcalculator.domain

class StringNumbers(text: String?) {
    private val stringNumbers: List<StringNumber>

    init {
        val splitData: String = when {
            text.isNullOrBlank() -> DEFAULT_DATA
            else -> text
        }
        stringNumbers = splitCustomDelimiterOrDefaultDelimiter(splitData)
    }

    fun sum(): Int {
        return stringNumbers.sumOf { it.value }
    }

    private fun splitCustomDelimiterOrDefaultDelimiter(text: String): List<StringNumber> {
        val result = Regex(CUSTOM_DELIMITER).find(text)
        result?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            return matchResult.groupValues[2].split(customDelimiter).map { StringNumber(it) }
        }.let {
            return text.split(DEFAULT_DELIMITER.toRegex()).map { StringNumber(it) }
        }
    }

    companion object {
        private const val DEFAULT_DATA = "0"
        private const val DEFAULT_DELIMITER = "[,:]"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
