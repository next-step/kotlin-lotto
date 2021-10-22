package calculator.utils

object StringUtils {

    fun parseToNumbers(text: String?): List<Int> {
        require(!text.isNullOrBlank()) { return listOf(0) }
        val regex = Regex(PATTERN)
        val find = regex.find(text)

        find?.let {
            val (delimiter, seperatedText) = it.destructured
            return toNumbers(seperatedText.split(delimiter))
        }
        return toNumbers(text.split(Regex(COMMA_AND_COLON)))
    }

    private fun toNumbers(splitText: List<String>): List<Int> {
        return splitText.map { Integer.parseUnsignedInt(it) }
    }

    private const val COMMA_AND_COLON = ",|:"
    private const val PATTERN = "//(.)\n(.*)"
}
