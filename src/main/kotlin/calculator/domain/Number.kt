package calculator.domain

private const val SIMPLE_DELIMITER = ",|:"
val SIMPLE_DELIMITER_REGEX = Regex(SIMPLE_DELIMITER)
val NUMERIC_REGEX = Regex("[0-9]+")
val DELIMITER_REGEX = Regex("//(.)\n(.*)")

fun validate(string: String?): String {
    if (string.isNullOrBlank()) {
        return "0"
    }
    return string
}

fun matchResult(text: String): MatchResult? {
    return DELIMITER_REGEX.find(text)
}

fun getDelimiter(matchResult: MatchResult?): String {
    if (matchResult != null) {
        return matchResult.groupValues[1]
    }
    return SIMPLE_DELIMITER
}

fun parse(text: String): List<String> {
    val matchResult = matchResult(text)
    val delimiter = getDelimiter(matchResult)

    if (delimiter == SIMPLE_DELIMITER) {
        return text.split(SIMPLE_DELIMITER_REGEX)
    }

    return matchResult!!.groupValues[2].split(delimiter)
}

fun toIntOrNull(number: String): Int? {
    if (NUMERIC_REGEX.matches(number)) {
        return number.toInt()
    }
    return null
}

class Number(val number: Int) {
    constructor(number: String) : this(toIntOrNull(number) ?: throw IllegalArgumentException("숫자가 아닙니다"))
}
