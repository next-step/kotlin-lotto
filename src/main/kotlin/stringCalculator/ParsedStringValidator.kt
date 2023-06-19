package stringCalculator

object ParsedStringValidator {
    fun check(parsedString: List<String>): Boolean {
        return parsedString.none { !StringPositiveNumber.isPositiveNumber(it) }
    }
}