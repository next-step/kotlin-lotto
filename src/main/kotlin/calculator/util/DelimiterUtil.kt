package calculator.util

fun getCustomDelimiter(input: String?): String =
    input?.takeIf { it.startsWith(CUSTOM_DELIMITER_PREFIX) && it.contains(CUSTOM_DELIMITER_SUFFIX) }
        ?.substringAfter(CUSTOM_DELIMITER_PREFIX)?.substringBefore(CUSTOM_DELIMITER_SUFFIX) ?: ""

fun deleteCustomDelimiter(input: String?): String {
    if (input.isNullOrBlank()) return ""

    val regex = Regex("${Regex.escape(CUSTOM_DELIMITER_PREFIX)}.*?${Regex.escape(CUSTOM_DELIMITER_SUFFIX)}")
    return input.replace(regex, "").trim()
}

private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "₩n"
