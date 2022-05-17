package calculator

fun calculate(input: String?): Int {
    if (input.isNullOrBlank()) {
        return 0
    }

    val result = Regex("//(.)\n(.*)").find(input)
    val lists = result?.let {
        val customDelimiter = it.groupValues[1]
        it.groupValues[2].split(customDelimiter)
    } ?: input.split(",", ":")

    return lists
        .map { it.toInt() }
        .onEach { if (it < 0) throw RuntimeException() }
        .sumOf { it }
}
