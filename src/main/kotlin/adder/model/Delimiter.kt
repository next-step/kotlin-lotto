package adder.model

class Delimiter(private val input: String) {
    fun hasCustom(): Boolean {
        return REGEX.matches(input)
    }

    fun split(): List<String> {
        return if (hasCustom()) splitByCustom(input) else splitByDefault(input)
    }

    private fun splitByCustom(input: String): List<String> {
        val firstMatchResult: MatchResult = REGEX.find(input)!!
        val delimiter = findCustomDelimiter(firstMatchResult)

        return firstMatchResult.groupValues[INDEX_OF_TARGET_VALUE]
            .split(delimiter)
    }

    private fun splitByDefault(input: String): List<String> {
        return input.split(DELIMITER_1, DELIMITER_2).map { it.trim() }
    }

    private fun findCustomDelimiter(firstMatchResult: MatchResult): String {
        return firstMatchResult.groupValues[INDEX_OF_CUSTOM_DELIMITER]
    }

    companion object {
        private const val REGEX_FOR_DELIMITER = """//(.)\\n(.*)"""
        private const val DELIMITER_1 = ","
        private const val DELIMITER_2 = ";"
        private const val INDEX_OF_CUSTOM_DELIMITER = 1
        private const val INDEX_OF_TARGET_VALUE = 2
        private val REGEX = REGEX_FOR_DELIMITER.toRegex()
    }
}
