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

    fun toInt(): Int {
        return text.toIntOrNull() ?: throw RuntimeException("숫자가 아닙니다.")
    }

    fun split(): List<Int> {
        if (hasSymbol()) {
            return splitBySymbol()
        }
        TODO("Not yet implemented")
    }

    private fun hasSymbol(): Boolean {
        val symbols = listOf(COMMA, COLON)
        return symbols.any { text.contains(it) }
    }

    private fun splitBySymbol(): List<Int> {
        val numbers = text.split("$COMMA|$COLON".toRegex())
        return numbers.map {
            it.toIntOrNull() ?: throw RuntimeException("구분자 이외의 값은 숫자여야 합니다.")
        }
    }
}
