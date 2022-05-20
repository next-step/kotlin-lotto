package expressioncalculator.validator

interface Validator {
    fun validate(input: String?) = if (isValid(input)) ValidateResult.Success else ValidateResult.Failed

    fun isValid(input: String?): Boolean
}
