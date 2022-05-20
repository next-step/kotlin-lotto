package calculator.domain

class Params(strings: List<String>) {
    val values: List<Int>

    init {
        if (strings.any { it.isBlank() }) {
            throw RuntimeException("빈 문자열은 들어올 수 없습니다.")
        } else if (strings.any { !it.all { it.isDigit() } }) {
            throw RuntimeException("숫자가 아닌 입력은 들어올 수 없습니다.")
        }
        values = strings.map { it.toInt() }
    }
}
