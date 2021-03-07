package caculator

internal class TokenParser {

    internal fun parseToken(input: String): Numbers {
        val matchResult: MatchResult? = CUSTOM_PATTERN.matchEntire(input)
        val regex = matchResult?.groups?.get(CUSTOM_PATTERN_GROUP_SPLITTER_INDEX)?.value?.toRegex() ?: DEFAULT_PATTERN
        val numbers = matchResult?.groups?.get(CUSTOM_PATTERN_GROUP_NUMBERS_INDEX)?.value ?: input
        return parseNumbers(regex = regex, numbers = numbers)
    }

    private fun parseNumbers(numbers: String, regex: Regex): Numbers {
        return Numbers(numbers.split(regex).filter(String::isNotEmpty).map { Number(it) })
    }

    companion object {
        private val DEFAULT_PATTERN = Regex(",|:")
        private val CUSTOM_PATTERN: Regex = Regex("//(.+)\\n(.*)")

        private const val CUSTOM_PATTERN_GROUP_SPLITTER_INDEX = 1
        private const val CUSTOM_PATTERN_GROUP_NUMBERS_INDEX = 2
    }
}
