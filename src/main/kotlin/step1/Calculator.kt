package step1

object Calculator {
    fun sum(expression: String): Int {
       val numbers = expression.split(",", ":")
            .filter { it.isNotEmpty() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("숫자로 변환할 수 없습니다. 입력값: $it") }

        return numbers.sum()
    }
}
