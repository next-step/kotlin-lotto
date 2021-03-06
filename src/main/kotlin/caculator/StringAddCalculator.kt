package caculator

internal class StringAddCalculator(private val tokenParser: TokenParser) {

    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return Number.ZERO.value
        }
        return tokenParser.parseToken(input).sum().value
    }
}
