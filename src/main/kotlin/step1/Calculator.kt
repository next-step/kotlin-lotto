package step1

object Calculator {
    fun sum(expression: String): Int {
        val numbers = expression.split(",", ":")
            .filter { it.isNotEmpty() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("입력이 잘못 되었습니다. 입력값: $it") }

        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("음수는 넣을 수 없습니다.")
        }

        return numbers.sum()
    }
}
