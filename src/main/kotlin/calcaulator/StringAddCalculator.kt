package calcaulator

class StringAddCalculator {
    fun add(text: String?): Int {
        val tokens = text.parseInput()
        return tokens.sum()
    }
}
