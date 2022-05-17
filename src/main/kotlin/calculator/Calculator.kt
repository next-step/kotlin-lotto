package calculator

fun calculate(input: String?): Int {
    return checkValidation(input)?.let { text -> getSplitList(text).sumOf() } ?: 0
}

private fun checkValidation(input: String?): String? {
    return if (input.isNullOrBlank()) { null } else { input }
}

private fun getSplitList(input: String): List<String> {
    return Regex(DELIMITER_REGEX).find(input)?.let {
        it.groupValues[2].split(it.groupValues[1])
    } ?: input.split(",", ":")
}

private fun List<String>.sumOf(): Int {
    return this.map { it.toIntOrNull() ?: throw RuntimeException() }
        .onEach { if (it < 0) throw RuntimeException() }
        .sumOf { it }
}

const val DELIMITER_REGEX = "//(.)\n(.*)"
