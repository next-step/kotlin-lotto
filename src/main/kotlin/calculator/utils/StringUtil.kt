package calculator.utils

object StringUtil {
    private val BASIC_PATTERN = Regex(",|:")

    fun convertTextToList(text: String): List<String> = text.split(BASIC_PATTERN)
}
