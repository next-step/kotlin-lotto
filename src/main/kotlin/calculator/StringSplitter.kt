package calculator

object StringSplitter {
    private const val DELIMITER_COMMA = ","

    fun splitByComma(text: String): List<String> = text.split(DELIMITER_COMMA)
}
