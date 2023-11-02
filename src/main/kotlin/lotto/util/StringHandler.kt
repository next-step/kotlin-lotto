package lotto.util

class StringHandler {
    fun checkNonNumExists(input: String) {
        require(Regex("^[0-9]+$").matches(input)) { "구입 금액은 숫자로만 표현되어야 합니다." }
    }

    fun tokenizeWinningNumbers(input: String): List<Int> {
        return input
            .split(",")
            .filterNot { it.isBlank() }
            .map { it.trim().toInt() }
    }
}
