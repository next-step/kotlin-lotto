package step1

private const val FIRST_DELIMITERS = ","
private const val SECOND_DELIMITERS = ":"

object Calculator {
    fun sum(expression: String): Int {
        if (expression.startsWith("//") && expression.contains("\\n")) {
            val startIndex = expression.indexOf("//") + 2
            val endIndex = expression.indexOf("\\n")
            val separator = expression.substring(startIndex, endIndex)

            val data = expression.substring(endIndex + 2)

            val numbers = data.split(separator).filter { it.isNotEmpty() }
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("입력이 잘못 되었습니다. 입력값: $it") }

            if (numbers.any { it < 0 }) {
                throw IllegalArgumentException("음수는 넣을 수 없습니다.")
            }

            return numbers.sum()
        }

        val numbers = expression.split(FIRST_DELIMITERS, SECOND_DELIMITERS)
            .filter { it.isNotEmpty() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("입력이 잘못 되었습니다. 입력값: $it") }

        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("음수는 넣을 수 없습니다.")
        }

        return numbers.sum()
    }
}
