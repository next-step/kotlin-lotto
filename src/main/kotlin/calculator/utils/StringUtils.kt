package calculator.utils

object StringUtils {

    fun splitTextByDelimiter(text: String, delimiter: String): List<String> {
        return text.split(Regex(delimiter))
    }

    fun toNumbers(splitText: List<String>): List<Int> {
        return splitText.map { it.toInt() }
    }
}
