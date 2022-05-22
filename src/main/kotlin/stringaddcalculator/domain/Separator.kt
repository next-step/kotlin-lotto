package stringaddcalculator.domain

@JvmInline
value class Separator(val value: String) {
    init {
        require(value.length == VALID_LENGTH) { "구분자는 길이가 ${VALID_LENGTH}인 문자여야 합니다" }
        require(isNotNumeric(value)) { "구분자는 숫자일 수 없습니다" }
    }

    private fun isNotNumeric(string: String): Boolean = string.toCharArray().none { it.isDigit() }

    companion object {
        private const val VALID_LENGTH = 1
    }
}
