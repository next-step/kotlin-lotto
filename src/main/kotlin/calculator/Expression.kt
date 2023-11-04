package calculator

private const val COMMA = ","
private const val COLON = ":"
private const val FORWARD_SLASH = "//"
private const val NEW_LINE_CHARACTER = "\n"

class Expression(
    private val text: String
) {

    fun isNumber(): Boolean {
        val symbols = listOf(COMMA, COLON, FORWARD_SLASH, NEW_LINE_CHARACTER)
        return symbols.none { text.contains(it) }
    }

    fun toPositiveInt(): Int {
        val number = text.toIntOrNull() ?: throw RuntimeException("숫자가 아닙니다.")
        validateMinusNumber(number)
        return number
    }

    private fun validateMinusNumber(number: Int) {
        if (number < 0) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }

    fun split(): List<Int> {
        if (hasSymbol() && !hasCustomSymbol()) {
            return splitBySymbol()
        }
        return splitByCustomSymbol()
    }

    private fun hasSymbol(): Boolean {
        val symbols = listOf(COMMA, COLON)
        return symbols.any { text.contains(it) }
    }

    private fun splitBySymbol(): List<Int> {
        val numbers = text.split("$COMMA|$COLON".toRegex())
        return toPositiveNumbers(numbers)
    }

    private fun hasCustomSymbol(): Boolean {
        val symbols = listOf(FORWARD_SLASH, NEW_LINE_CHARACTER)
        return symbols.all { text.contains(it) }
    }

    private fun splitByCustomSymbol(): List<Int> {
        val result = Regex("$FORWARD_SLASH(.)$NEW_LINE_CHARACTER(.*)").find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            val numbers = it.groupValues[2].split(customDelimiter)
            toPositiveNumbers(numbers)
        } ?: throw RuntimeException("잘못된 수식입니다.")
    }

    private fun toPositiveNumbers(numbers: List<String>) = numbers.map {
        Expression(it).toPositiveInt()
    }
}
