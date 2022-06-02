package stringAddCalculator

internal fun toNumbers(strings: List<String>): List<Int> = strings.map { toNumber(it) }

private fun toNumber(text: String): Int {
    val int = text.toIntOrNull()
    if (int == null || int < 0) throw RuntimeException("숫자 이외의 값 또는 음수가 전달되었습니다.")
    return int
}
