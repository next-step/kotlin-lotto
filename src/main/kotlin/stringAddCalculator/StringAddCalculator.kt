package stringAddCalculator

object StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val tokens = StringSeparator.separate(text)
        return tokens.sum()
    }
}
