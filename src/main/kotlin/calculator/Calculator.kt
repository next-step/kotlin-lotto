package calculator

fun calculate(input: String?): Int {
    return checkValidation(input)
        ?.let { text -> getSplitList(text).sumOf() }
        ?: 0
}

private fun checkValidation(input: String?): String? {
    return input.takeUnless {
        it.isNullOrBlank()
    }
}

private fun getSplitList(input: String): List<String> {
    return DELIMITER_REGEX.toRegex().find(input)
        ?.let {
            val (_, delimiter, target) = it.groupValues
            target.split(delimiter)
        }
        ?: input.split(",", ":")
}

private fun List<String>.sumOf() = sumOf {
    it.toIntOrNull()
        ?.takeIf { number -> number >= 0 }
        ?: throw RuntimeException()
}

const val DELIMITER_REGEX = "//(.)\n(.*)"
