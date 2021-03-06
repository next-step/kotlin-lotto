package caculator

internal class TokenParser {

    fun parseToken(input: String): List<Int> {
        var regex = DEFAULT_PATTERN
        var numbers = input
        val matchResult: MatchResult? = CUSTOM_PATTERN.matchEntire(input)
        if (matchResult != null) {
            regex = Regex(matchResult.groups[1]?.value!!)
            numbers = matchResult.groups[2]?.value!!
        }

        return parseNumbers(regex = regex, numbers = numbers)
    }

    private fun parseNumbers(numbers: String, regex: Regex): List<Int> {
        return numbers.split(regex).map(String::toInt)
    }

    companion object {
        private val DEFAULT_PATTERN = Regex(",|:")
        private val CUSTOM_PATTERN: Regex = Regex("//(.)\\n(.*)")
    }
}
