package util

object Separator {

    private val REGEX = Regex("//(.*?)\n(.*)")
    private val DEFAULT_DELIMITERS = listOf(":", ",")
    private const val ONLY_NUMERIC_TYPE_ERROR = "숫자 이외의 값 혹은 음수는 사용될 수 없습니다"
    private const val ONLY_POSITIVE_ERROR = "양수만 사용될 수 있습니다."

    fun extractIntegers(text: String?): List<Int> {
        require(!text.isNullOrEmpty()) { return listOf(0) }

        return REGEX.matchEntire(text)?.destructured?.let { (delimiter, splitText) ->
            splitAndFilterPositiveValues(splitText, listOf(delimiter))
        } ?: splitAndFilterPositiveValues(text)
    }

    private fun splitAndFilterPositiveValues(
        text: String,
        delimiters: List<String> = DEFAULT_DELIMITERS,
    ): List<Int> {
        return text.split(*delimiters.toTypedArray())
            .map(::positiveNumber)
    }

    private fun positiveNumber(number: String): Int {
        val parsedInt = number.trim().toIntOrNull() ?: throw IllegalArgumentException(ONLY_NUMERIC_TYPE_ERROR)
        require(parsedInt >= 0) { ONLY_POSITIVE_ERROR }
        return parsedInt
    }
}
