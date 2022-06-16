package domain

class Expression(text: String) {
    var numbers: List<Int>
        private set

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
            throw RuntimeException()
        }
    }

    companion object {
        const val DELIMITER_COMMA = ","
        const val DELIMITER_COLON = ":"
    }
}