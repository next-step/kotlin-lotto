package adder.model

data class Numbers(val nums: List<Number>) {

    constructor(input: Collection<String>) : this(input.map(::Number))

    constructor(input: String) : this(split(input))

    fun getSum(): Int {
        return nums.sumBy { it.value }
    }

    companion object {
        private const val REGEX_FOR_DELIMITER = """//(.)\\n(.*)"""
        private const val DELIMITER_1 = ","
        private const val DELIMITER_2 = ";"
        private const val INDEX_OF_CUSTOM_DELIMITER = 1
        private const val INDEX_OF_TARGET_VALUE = 2
        private val REGEX = REGEX_FOR_DELIMITER.toRegex()

        private fun split(input: String): List<String> {
            val hasCustom = REGEX.matches(input)
            return if (hasCustom) splitByCustom(input) else splitByDefault(input)
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
    }
}
