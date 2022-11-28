package lotto.domain

object InputParser {
    private const val INPUT_DELIMITER = ", "

    fun parseWithDelimiter(input: String): List<Int> {
        return input.split(INPUT_DELIMITER).map { it.toIntOrNull() ?: throw IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.") }
    }
}
