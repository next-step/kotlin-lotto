package calculator

object Calculator {
    fun execute(input: String?): String {
        return try {
            inputValidate(input)
            val result = InputStringParser(input!!).getSeperatedValue().sum()
            result.toString()
        } catch (e: RuntimeException) {
            when (e) {
                is InvalidInputException -> e.message.toString()
                else -> throw e
            }
        }
    }

    private fun inputValidate(input: String?) {
        validateInputIsNullOrBlank(input)
        validateInputIsOnlyNumber(input!!)
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
