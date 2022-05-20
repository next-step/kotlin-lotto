package expressioncalculator.validator

object EmptyValidator : Validator {
    override fun isValid(input: String?): Boolean {
        return input.isNullOrBlank()
    }
}
