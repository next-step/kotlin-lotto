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
        if (!isNumber()) {
            throw RuntimeException("숫자가 아닙니다.")
        }
        return text.toInt()
    }
}
