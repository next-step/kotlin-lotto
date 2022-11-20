package lotto.util

object StringValidator {
    fun validateNumber(string: String) {
        val isNumeric = string.toCharArray().all { it in '0'..'9' }
        if (!isNumeric) {
            throw IllegalArgumentException("숫자가 아닙니다. (입력값:$string)")
        }
    }

    fun validateNotBlank(string: String) {
        if (string.isBlank()) {
            throw IllegalArgumentException("값이 비어있습니다.")
        }
    }
}
