package expressioncalculator.validator

object SingleIntegerValidator : Validator {
    override fun isValid(input: String?): Boolean {
        return input?.toIntOrNull() != null
    }
}
