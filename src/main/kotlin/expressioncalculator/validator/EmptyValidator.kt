package expressioncalculator.validator

object EmptyValidator : Validator {
    override fun validate(input: String?): Boolean {
        return input.isNullOrBlank()
    }
}
