package lotto.util

object StringParser {
    fun convertToInt(input: String): Int = input.toIntOrNull() ?: throw RuntimeException("숫자로 입력하지 않았습니다.")

    fun convertToInts(input: String): List<Int> =
        input.split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .map {
                it.toIntOrNull() ?: throw NumberFormatException("숫자로 입력하지 않았습니다.")
            }
}
