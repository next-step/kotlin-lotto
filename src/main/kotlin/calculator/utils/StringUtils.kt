package calculator.utils

object StringUtils {

    fun splitTextByDelimiter(text: String): List<String> {
        val regex = Regex(PATTERN)
        val find = regex.find(text)

        find?.let {
            val (delimiter, seperatedText) = it.destructured
            return seperatedText.split(delimiter)
        }
        return text.split(Regex(COMMA_AND_COLON))
    }

    fun toNumbers(splitText: List<String>): List<Int> {
        return splitText.map { it.toInt() }
    }

    private const val COMMA_AND_COLON = ",|:"
    private const val PATTERN = "//(.)\n(.*)"
}
