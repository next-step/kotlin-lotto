package stringadder.domain

class Delimiters(input: String) {
    var list: List<String> = DEFAULT_DELIMITERS
    // TODO 질문 : listOf 하고 + 연산자 vs ArrayList 하고 add

    init {
        validateContainDelimiters(input)
        list = DEFAULT_DELIMITERS + listOf(input[DELIMITER_INDEX].toString())
    }

    private fun validateContainDelimiters(input: String) {
        require(isDelimiterCondition(input)) { "${DELIMITER_PREFIX}와 ${DELIMITER_SUFFIX}사이에 구분자를 입력해야 합니다." }
    }

    private fun isDelimiterCondition(input: String) =
        input.startsWith(DELIMITER_PREFIX) && input.startsWith(DELIMITER_SUFFIX, SUFFIX_START_INDEX)

    companion object {
        private val DEFAULT_DELIMITERS = listOf(",", ":")
        private const val DELIMITER_PREFIX = "//"
        private const val DELIMITER_SUFFIX = "\\n"
        private const val SUFFIX_START_INDEX = 3
        private const val DELIMITER_INDEX = 2
    }
}
