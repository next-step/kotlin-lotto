package calculator.util

fun getCustomDelimiter(input: String?): String =
    input?.takeIf { it.startsWith(CUSTOM_DELIMITER_PREFIX) && it.contains(CUSTOM_DELIMITER_SUFFIX) }
        ?.substringAfter(CUSTOM_DELIMITER_PREFIX)?.substringBefore(CUSTOM_DELIMITER_SUFFIX) ?: ""

private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val CUSTOM_DELIMITER_SUFFIX = "₩n"
