package calculator

object StringAddCalculator {
    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }
        val tokens = IntTokenizer.tokenize(input)

        return tokens.sum()
    }
}
