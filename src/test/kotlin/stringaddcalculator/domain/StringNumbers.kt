package stringaddcalculator.domain

class StringNumbers(text: String?) {
    private val stringNumbers: List<StringNumber>

    init {
        val splitData: String = when {
            text.isNullOrBlank() -> DEFAULT_DATA
            else -> text
        }
        stringNumbers = splitData.split(DEFAULT_DELIMITER.toRegex()).map { StringNumber(it) }
    }

    fun sum(): Int {
        return stringNumbers.sumOf { it.value }
    }

    companion object {
        private const val DEFAULT_DATA = "0"
        private const val DEFAULT_DELIMITER = "[,:]"
    }
}
