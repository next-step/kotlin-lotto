package calculator.utils

object StringUtil {
    private const val COMMA = ","

    fun convertTextToList(text: String): List<String> =
        text.split(COMMA)
}
