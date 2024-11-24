package step1

object Calculator {
    fun sum(expression: String): Int {
       val numbers = expression.split(",", ":")
            .filter { it.isNotEmpty() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("입력이 잘못 되었습니다. 입력값: $it") }

        return numbers.sum()
    }
}
