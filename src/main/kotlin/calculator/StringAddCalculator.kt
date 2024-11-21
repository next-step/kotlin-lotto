package calculator

private const val DELIMITER = ","

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val numbers = text.split(DELIMITER)
        return numbers.sumOf { it.toIntOrThrowIfInvalid() }
    }

    private fun String.toIntOrThrowIfInvalid(): Int {
        return this.toIntOrNull()?.also {
            if (it < 0) throw RuntimeException("음수를 입력할 수 없습니다 : $this")
        } ?: throw RuntimeException("잘못된 입력값입니다 : $this")
    }
}
