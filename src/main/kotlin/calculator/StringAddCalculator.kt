package calculator

private const val DELIMITER = ","

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = text.split(DELIMITER)
        return numbers.sumOf { it.toIntOrNull() ?: throw RuntimeException("잘못된 입력값입니다 : $it") }
    }
}
