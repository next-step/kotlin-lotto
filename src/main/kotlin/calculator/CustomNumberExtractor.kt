package calculator

class CustomNumberExtractor(
    expression: String,
) : NumberExtractor(expression) {

    override fun extractNumbers(): List<Int> {
        val matchResult = customPatternRegex.find(expression)
        return matchResult?.let { result ->
            val customDelimiter = result.groupValues[1]
            result.groupValues[2].split(customDelimiter).map { NonNegativeNumber(it).value }
        } ?: throw IllegalArgumentException()
    }
}
