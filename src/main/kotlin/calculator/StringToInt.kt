package calculator

private const val NULL_OR_EMPTY_VALUE = 0

fun parseToInt(string: String?): Int {
    if (string.isNullOrBlank()) {
        return NULL_OR_EMPTY_VALUE
    }

    return try {
        string.toInt()
    } catch (e: Exception) {
        throw RuntimeException()
    }
}
