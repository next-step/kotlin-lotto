package caculator

internal class StringAddCalculator(private val tokenParser: TokenParser) {

    internal fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return EMPTY_VALUE
        }
        val numbers = tokenParser.parseToken(input)
        return numbers.sum()
    }

    companion object {
        private const val EMPTY_VALUE = 0
    }
}
