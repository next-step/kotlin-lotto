package calculator

class Expression(
    private val text: String,
) {

    fun isNumber(): Boolean {
        return SPECIAL_SYMBOLS.none { text.contains(it) }
    }

    fun toPositiveInt(): Int {
        val number = text.toIntOrNull() ?: throw RuntimeException("숫자가 아닙니다.")
        validateMinusNumber(number)
        return number
    }

    private fun validateMinusNumber(number: Int) {
        require(number >= 0) {
            "음수는 입력할 수 없습니다."
        }
    }

    fun split(): List<Int> {
        if (hasSymbol() && hasCustomSymbol().not()) {
            return splitBySymbol()
        }
        return splitByCustomSymbol()
    }

    private fun hasSymbol(): Boolean {
        return GENERAL_SYMBOLS.any { text.contains(it) }
    }

    private fun splitBySymbol(): List<Int> {
        val numbers = text.split(GENERAL_SYMBOL_REGEX)
        return toPositiveNumbers(numbers)
    }

    private fun hasCustomSymbol(): Boolean {
        return CUSTOM_SYMBOLS.all { text.contains(it) }
    }

    private fun splitByCustomSymbol(): List<Int> {
        val result = CUSTOM_SYMBOL_REGEX.find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            val numbers = it.groupValues[2].split(customDelimiter)
            toPositiveNumbers(numbers)
        } ?: throw RuntimeException("잘못된 수식입니다.")
    }

    private fun toPositiveNumbers(numbers: List<String>) = numbers.map {
        Expression(it).toPositiveInt()
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private const val FORWARD_SLASH = "//"
        private const val NEW_LINE_CHARACTER = "\n"

        private val SPECIAL_SYMBOLS = listOf(COMMA, COLON, FORWARD_SLASH, NEW_LINE_CHARACTER)
        private val GENERAL_SYMBOLS = listOf(COMMA, COLON)
        private val GENERAL_SYMBOL_REGEX = "$COMMA|$COLON".toRegex()
        private val CUSTOM_SYMBOLS = listOf(FORWARD_SLASH, NEW_LINE_CHARACTER)
        private val CUSTOM_SYMBOL_REGEX = Regex("$FORWARD_SLASH(.)$NEW_LINE_CHARACTER(.*)")
    }
}
