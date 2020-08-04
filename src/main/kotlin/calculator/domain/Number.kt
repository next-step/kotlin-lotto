package calculator.domain

const val SIMPLE_DELIMITER = ",|:"
val SIMPLE_DELIMITER_REGEX = Regex(SIMPLE_DELIMITER)
val NUMERIC_REGEX = Regex("[0-9]")
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

fun parse(text: String, customDelimiter: String): List<String> {

    if (customDelimiter == SIMPLE_DELIMITER) {
        return text.split(SIMPLE_DELIMITER_REGEX)
    }
    return matchResult(text)!!.groupValues[2].split(customDelimiter)
}

fun findCustomDelimiter(text: String): String {
    val matchResult = matchResult(text)
    if (matchResult != null && matchResult.groupValues[1].isNotBlank()) {
        return matchResult.groupValues[1]
    }
    return SIMPLE_DELIMITER
}

class Number(val number: String) {

    fun isNatural(): Boolean {
        if (NUMERIC_REGEX.matches(number)) {
            return true
        }
        throw IllegalArgumentException("숫자가 아닙니다")
    }
}
