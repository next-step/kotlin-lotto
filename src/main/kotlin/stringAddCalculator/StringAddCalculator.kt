package stringAddCalculator

class StringAddCalculator {
    fun add(text: String?): Int {
        val tokens = Tokenizer.tokenize(text)
        Tokenizer.validate(tokens)
        return tokens.sumOf { it.trim().toInt() }
    }
}
