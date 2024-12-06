package calculator.domain

class InputTokenizer(inputString: String?) {
    private val delimiter: String
    private val tokens: List<String>

    init {
        println("input = $inputString")
        if (inputString.isNullOrBlank()) {
            delimiter = DEFAULT_DELIMITER
            tokens = emptyList()
        } else {
            val result = Regex(DELIMITER_FILTER_EXPRESS).find(inputString)
            if (result?.groupValues?.size == 3) { // 커스텀 구분자
                delimiter = result.groupValues[1]
                tokens = result.groupValues[2].split(delimiter)
            } else {
                delimiter = DEFAULT_DELIMITER
                tokens = inputString.split(delimiter.toRegex())
            }
        }
    }

    fun getDelimiter() = delimiter

    fun getTokensIterator() = tokens.iterator()

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        const val DELIMITER_FILTER_EXPRESS = "//(.)\\n(.*)"
    }
}
