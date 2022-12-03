package lotto.util

object StringValidator {

    fun validateNumber(string: String) {
        require(string.isNumeric()) { "숫자가 아닙니다." }
    }

    private fun String.isNumeric(): Boolean {
        return this.toCharArray().all { it in '0'..'9' }
    }

    fun validateNotBlank(string: String) {
        require(!string.isBlank()) { "값이 비어 있습니다." }
    }
}
