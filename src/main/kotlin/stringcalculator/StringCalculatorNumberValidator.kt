package stringcalculator

class StringCalculatorNumberValidator {

    fun ensureAllPositiveNumbers(input: List<String>) = input.forEach { ensurePositiveNumber(it) }

    fun ensurePositiveNumber(it: String) {
        val number = it.toIntOrNull()
        require(number != null && number >= 0) { "0보다 큰 숫자 이여야 한다." }
    }
}
