package calculator

import java.util.regex.Matcher
import java.util.regex.Pattern

private const val DEFAULT_DELIMITER_COMMA = ","
private const val DEFAULT_DELIMITER_COLON = ":"
private const val CUSTOM_DELIMITER_INDEX = 1
private const val CUSTOM_DELIMITER_NUMBER_INDEX = 2
private val customDelimiterPattern = Pattern.compile("^//(.)\\n(.*)$")

fun calculate(formula: String): Int {
    if (formula.isBlank()) {
        return 0
    }
    val customDelimiterMatcher = customDelimiterPattern.matcher(formula)
    if (customDelimiterMatcher.find()) {
        val numbers = parseCustomCalculateNumbers(customDelimiterMatcher)
        return calculate(numbers)
    }
    val numbers = formula.split(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)
    return calculate(numbers)
}

private fun parseCustomCalculateNumbers(customDelimiterMatcher: Matcher): List<String> {
    val originFormula = customDelimiterMatcher.group(CUSTOM_DELIMITER_NUMBER_INDEX)
    val customDelimiter = customDelimiterMatcher.group(CUSTOM_DELIMITER_INDEX)
    return originFormula.split(customDelimiter)
}

private fun calculate(numbers: List<String>) = numbers.map { PositiveNumber.from(it) }
    .reduce { total, num -> total + num }
    .value
