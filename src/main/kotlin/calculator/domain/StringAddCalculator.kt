package calculator.domain

object StringAddCalculator {
    private const val NULL_OR_BLANK_RESULT = 0

    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) return NULL_OR_BLANK_RESULT

        val tokens = StringAddTokenizer(text).getTokens()
        return tokens.map { token ->
            StringNumber.valueOf(token)
        }.sumOf {
            it.value
        }
    }
}
