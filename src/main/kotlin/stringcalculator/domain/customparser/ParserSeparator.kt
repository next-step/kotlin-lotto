package stringcalculator.domain.customparser

@JvmInline
value class ParserSeparator(val string: String) {

    init {
        validate()
    }

    private fun validate() {
        require(string.isNotEmpty()) { ERROR_MESSAGE_IS_EMPTY }
        require(!REGEX_FIND_NUMBER.containsMatchIn(string)) { ERROR_MESSAGE_HAS_NUMBER }
    }

    companion object {
        private const val ERROR_MESSAGE_IS_EMPTY = "구분자는 비워진 문자열로 넣을수 없습니다"
        private const val ERROR_MESSAGE_HAS_NUMBER = "구분자는 숫자를 포함 할수 없습니다"
        private val REGEX_FIND_NUMBER = Regex("(\\d)")
    }
}
