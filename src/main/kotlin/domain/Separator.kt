package domain

class Separator {

    fun extractIntegers(input: String?): List<Int> {
        require(!input.isNullOrEmpty()) { return listOf(0) }

        return REGEX.matchEntire(input)?.destructured?.let { (delimiter, splitText) ->
            splitAndFilterPositiveValues(splitText, listOf(delimiter))
        } ?: splitAndFilterPositiveValues(input)
    }

    private fun splitAndFilterPositiveValues(
        text: String,
        delimiter: List<String> = DEFAULT_DELIMITERS,
    ): List<Int> {
        return text.split(*delimiter.toTypedArray())
            .map(::positiveNumbers)
    }

    private fun positiveNumbers(number: String): Int {
        val parsedInt = number.toIntOrNull() ?: throw IllegalArgumentException(ONLY_NUMERIC_TYPE_ERROR)
        require(parsedInt > 0) { ONLY_POSITIVE_ERROR }
        return parsedInt
    }

    companion object {
        private val REGEX = Regex("//(.*?)\n(.*)")
        private val DEFAULT_DELIMITERS = listOf(":", ",")
        private const val ONLY_NUMERIC_TYPE_ERROR = "숫자 이외의 값 혹은 음수는 사용될 수 없습니다"
        private const val ONLY_POSITIVE_ERROR = "양수만 사용될 수 있습니다."
    }
}
