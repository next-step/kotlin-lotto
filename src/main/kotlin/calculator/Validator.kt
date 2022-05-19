package calculator

object Validator {
    fun inputValidate(input: String?) {
        validateInputIsNullOrBlank(input)
        validateInputIsOnlyNumber(input!!)
    }

    fun negativeNumberValidate(numbers: List<Int>) {
        if (numbers.any { it < 0 }) throw InvalidInputNumberException()
    }

    private fun validateInputIsNullOrBlank(input: String?) {
        if (input.isNullOrEmpty()) throw InvalidInputException(ZERO)
        if (input.isBlank()) throw InvalidInputException(ZERO)
    }

    private fun validateInputIsOnlyNumber(input: String) {
        if (input.filterNot { it.isDigit() }.isEmpty()) throw InvalidInputException(input)
    }

    private const val ZERO = "0"
}
