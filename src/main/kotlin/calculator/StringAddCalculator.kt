package calculator

private const val BASIC_DELIMITER = ",:"
private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "\n"
private const val POSITIVE_VALUE_THRESHOLD = 0

class StringAddCalculator {
    fun add(source: String?): Long {
        if (source.isNullOrEmpty()) {
            return 0
        }
        val delimiterWithCustom = source.toDelimiterRegex()
        val candidatesToAdd = source.convertToCandidatesToAdd()
        return candidatesToAdd.split(delimiterWithCustom)
            .sumOf { it.toPositiveValue() }
    }
}

private fun String.toPositiveValue(): Long {
    val convertedNumber = this.toLong()
    require(convertedNumber >= POSITIVE_VALUE_THRESHOLD) { "음수는 입력할 수 없습니다." }
    return convertedNumber
}

private fun String.toDelimiterRegex(): Regex {
    val customDelimiter = this.substringAfter(CUSTOM_DELIMITER_PREFIX, "")
        .substringBefore(CUSTOM_DELIMITER_SUFFIX, "")
    return "[${BASIC_DELIMITER + customDelimiter}]".toRegex()
}

private fun String.convertToCandidatesToAdd(): String {
    return this.substringAfter(CUSTOM_DELIMITER_SUFFIX)
}
