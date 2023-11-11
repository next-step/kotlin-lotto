package calculator

class Delimiters {

    private val _delimiters: MutableList<String> = mutableListOf()
    val values: List<String>
        get() = _delimiters.toList()

    fun add(delimiter: String) {
        _delimiters.add(delimiter)
    }

    fun add(delimiterList: List<String>) {
        _delimiters.addAll(delimiterList)
    }

    fun validateInput(input: String) {
        val regex = _delimiters.joinToString("|").toRegex()
        
        input.split(regex).forEach { token ->
            validateIsNumeric(token)
        }
    }

    private fun validateIsNumeric(token: String) {
        if (token.toIntOrNull() == null) {
            throw RuntimeException("입력 값은 쉼표(,), 콜론(:), 커스텀 구분자를 제외한 나머지 문자는 모두 숫자로 입력해야 합니다.")
        }
    }

    fun extractPositiveNumbers(input: String): PositiveNumbers {
        val positiveNumbers = PositiveNumbers()

        input.split(*_delimiters.toTypedArray())
            .map { positiveNumbers.add(it.toInt()) }

        return positiveNumbers
    }
}
