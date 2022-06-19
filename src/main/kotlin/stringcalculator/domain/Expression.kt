package stringcalculator.domain

class Expression(text: String) {
    val numbers: List<Int>

    init {
        numbers = text.parse().checkValid()
    }

    private fun String.parse(): List<String> {
        return Regex("//(.)\n(.*)").find(this)?.let {
            it.groupValues[2].split(it.groupValues[1])
        } ?: this.split(DELIMITER_COLON, DELIMITER_COMMA)
    }

    private fun List<String>.checkValid(): List<Int> {
        try {
            val numbers = this.map { it.toInt() }
            return if (numbers.any { it < 0 }) throw RuntimeException() else numbers
        } catch (e: NumberFormatException) {
            throw RuntimeException("sdfsdf")
        }
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
    }
}
