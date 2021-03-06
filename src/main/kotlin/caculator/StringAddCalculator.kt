package caculator

internal class StringAddCalculator(private val tokenParser: TokenParser) {

    fun add(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return 0
        }
        return tokenParser.parseToken(input).sum()
    }
}
