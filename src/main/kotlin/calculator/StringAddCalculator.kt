package calculator

class StringAddCalculator {

    fun add(input: String?): Long {
        if (input.isNullOrBlank()) return 0

        val tokens = Tokenizer.tokenize(input)
        return tokens.sumOf { it.toPositiveLong() }
    }
}
