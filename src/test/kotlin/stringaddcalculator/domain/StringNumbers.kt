package stringaddcalculator.domain

class StringNumbers(text: String?) {
    private val stringNumbers: List<StringNumber>

    init {
        val splitData: String = when {
            text.isNullOrBlank() -> DEFAULT_DATA
            else -> text
        }
        stringNumbers = splitData.split(",|:".toRegex()).map { StringNumber(it) }
    }

    companion object {
        private const val DEFAULT_DATA = "0"
    }
}
