package stringaddcalculator.domain

@JvmInline
value class Separator(val value: String) {
    init {
        require(value.length == VALID_LENGTH) { "구분자는 길이가 ${VALID_LENGTH}인 문자여야 합니다" }
        require(value.isNotNumeric()) { "구분자는 숫자일 수 없습니다" }
    }

    companion object {
        private const val VALID_LENGTH = 1
    }
}

fun String.isNotNumeric(): Boolean = toCharArray().none { it.isDigit() }
