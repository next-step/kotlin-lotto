package calculator

class Delimiters(delimiters: List<String>) {

    private val _delimiters: List<String> = delimiters
    val values: List<String>
        get() = _delimiters.toList()

    fun validateInput(input: String) {
        val regex = _delimiters.joinToString("|").toRegex()
        input.split(regex).forEach { token ->
            validateIsNumeric(token)
        }
    }

    private fun validateIsNumeric(token: String) {
        require(token.toIntOrNull() != null) {
            "입력 값은 쉼표(,), 콜론(:), 커스텀 구분자를 제외한 나머지 문자는 모두 숫자로 입력해야 합니다. token: $token"
        }
    }

    fun extractPositiveNumbers(input: String): PositiveNumbers {
        val inputNumbers = input.split(*_delimiters.toTypedArray())
            .map { it.toInt() }

        return PositiveNumbers(inputNumbers)
    }
}
