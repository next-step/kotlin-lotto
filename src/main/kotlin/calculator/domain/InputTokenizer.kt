package calculator.domain

class InputTokenizer(inputString: String) {
    private val delimiter: String
    private val tokens: List<String>

    init {
        val result = REGEX_FILTER_OBJECT.find(inputString)
        if (result != null) { // 커스텀 구분자
            delimiter = result.groupValues[1]
            tokens = result.groupValues[2].split(delimiter)
        } else {
            delimiter = DEFAULT_DELIMITER
            tokens = inputString.split(delimiter.toRegex())
        }
    }

    fun getTokens(): List<Int> {
        return tokens.map {
            it.toIntOrNull() ?: 0
        }.toList()
    }

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        val REGEX_FILTER_OBJECT = Regex("//(.)\\n(.*)")
    }
}
