package stringaddcalculator.domain

@JvmInline
value class Separator(val value: String) {
    init {
        require(value.isNotEmpty()) { "구분자의 길이는 1 이상이어야 합니다" }
        require(value.isNotNumeric()) { "구분자는 숫자일 수 없습니다" }
    }
}

fun String.isNotNumeric(): Boolean = toCharArray().none { it.isDigit() }
