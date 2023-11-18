package calculator

class StringAddCalculator {
    fun add(text: String): Int {
        if (text.isBlank()) return 0
        require(text.toIntOrNull() != null) { "잘못된 문자열을 입력할 수 없습니다." }
        require(text.toInt() >= 0) { "음수를 입력할 수 없습니다." }
        return text.toInt()
    }
}
