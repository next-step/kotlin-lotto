package stringcalculator.domain

class Expression(text: String) {
    val positiveNumbers: List<Int>

    init {
        positiveNumbers = text.parse().checkNotNumber().checkNegative()
    }

    private fun String.parse(): List<String> {
        return Regex("//(.)\n(.*)").find(this)?.let {
            it.groupValues[2].split(it.groupValues[1])
        } ?: this.split(DELIMITER_COLON, DELIMITER_COMMA)
    }

    private fun List<String>.checkNotNumber(): List<Int> {
        try {
            this.map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw RuntimeException("숫자가 아닌 값이 포함됨 : 숫자만 입력해주세요")
        }
        return this.map { it.toInt() }
    }

    private fun List<Int>.checkNegative(): List<Int> {
        return if (this.any { it < 0 }) throw RuntimeException("음수가 포함됨 : 양수만 입력해주세요") else this
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
    }
}
