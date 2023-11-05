package calculator

class StringAddCalculator {

    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) return EMPTY_RESULT

        val split: List<String> = input.split(DELIMITER_REGEX)

        return split.sumOf { it.toInt() }
    }

    companion object {
        private const val EMPTY_RESULT = 0
        private val DELIMITER_REGEX = "[,|:]".toRegex()
    }
}
