package calculator

object Calculator {
    fun execute(input: String?): String {
        return try {
            Validator.inputValidate(input)
            val result = InputStringParser(input!!).getSeperatedValue().sum()
            result.toString()
        } catch (e: RuntimeException) {
            when (e) {
                is InvalidInputException -> e.message.toString()
                else -> throw e
            }
        }
    }
}
