package stringaddcalculator.util

class Splitter(private val delimiter: String? = null) {
    companion object {
        const val DEFAULT_DELIMITER1 = ","
        const val DEFAULT_DELIMITER2 = ":"
    }

    fun split(input: String): List<String> {
        if (delimiter.isNullOrBlank()) {
            return input.split(DEFAULT_DELIMITER1, DEFAULT_DELIMITER2)
        }
        return input.split(delimiter)
    }
}
