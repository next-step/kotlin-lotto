package stringcalculator

class StringCalculatorNumberValidator {

    fun ensurePositiveNumber(it: String) {
        val number = it.toIntOrNull()
        require(number != null && number >= 0) { "0보다 큰 숫자 이여야 한다." }
    }
}
