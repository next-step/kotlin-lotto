package calculator.domain

object Calculator {
    fun run(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        val tokens = Translator().translate(input)
        return tokens.sum()
    }
}
