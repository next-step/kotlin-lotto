package expressioncalculator.validator

class RegexMatchedValidator(private val regex: Regex) : Validator {
    override fun isValid(input: String?): Boolean {
        return input?.let {
            regex.matches(it)
        } ?: false
    }
}
