package calculator

fun calculate(input: String?): Int {
    if (input.isNullOrBlank()) {
        return 0
    }

    val result = Regex(DELIMITER_REGEX).find(input)
    val lists = result?.let {
        val customDelimiter = it.groupValues[1]
        it.groupValues[2].split(customDelimiter)
    } ?: input.split(",", ":")

    return lists
        .map { it.toIntOrNull() ?: throw RuntimeException() }
        .onEach { if (it < 0) throw RuntimeException() }
        .sumOf { it }
}

const val DELIMITER_REGEX = "//(.)\n(.*)"