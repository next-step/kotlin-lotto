package expressioncalculator.validator

object SingleIntegerValidator : Validator {
    override fun validate(input: String?): Boolean {
        return input?.toIntOrNull() != null
    }
}
