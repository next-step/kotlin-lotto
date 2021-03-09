package calculator

object Calculator {
    fun add(input: String): Int {
        if (input.isBlank()) {
            return 0
        }

        val result = Regex("//(.)\n(.*)").find(input)
            ?: return input.split(Delimiters.COMMA.value, Delimiters.SEMICOLON.value)
            .filter { it.isNotBlank() }
            .map { it.toIntOnlyPositive() }
            .sum()

        result.let {
            val delimiter = it.groupValues[1]
            val tokens = it.groupValues[2]

            return tokens.replace(delimiter, "").map { token -> token.toInt() }.sum()
        }
    }

    private fun String.toIntOnlyPositive(): Int {
        val toInt = this.toIntOrNull()?: throw throw IllegalArgumentException("잘못된 값입니다.")

        if (toInt < 0) {
            throw IllegalArgumentException("음수는 입력할 수 없습니다")
        }

        return toInt
    }
}
