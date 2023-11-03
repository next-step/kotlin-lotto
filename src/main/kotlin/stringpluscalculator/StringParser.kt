package stringpluscalculator

private const val DEFAULT_DELIMITERS = "[,:]"
private val inputRegex = Regex("//(.)\n(.*)")

object StringParser {
    fun parser(input: String): List<String> {
        val tokens = firstSplit(input)
        return secondSplit(tokens, input)
    }

    private fun firstSplit(input: String): List<String> {
        val result = inputRegex.find(input)
        var tokens = listOf<String>()
        result?.let {
            val customDelimiter = it.groupValues[1]
            tokens = it.groupValues[2].split(customDelimiter)
        }
        return tokens
    }

    private fun secondSplit(tokens: List<String>, input: String): List<String> {
        if (tokens.isEmpty()) {
            return input.split(DEFAULT_DELIMITERS.toRegex())
        }
        return tokens.filter { it.isNotBlank() }.flatMap { it.split(DEFAULT_DELIMITERS.toRegex()) }
    }
}
