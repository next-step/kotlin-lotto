package calcaulator

class StringAddCalculator {
    fun add(text: String?): Int {
        val tokens = text.parseInput()
        return if (tokens.isEmpty()) 0 else tokens.reduce { a, b -> a + b }
    }
}
