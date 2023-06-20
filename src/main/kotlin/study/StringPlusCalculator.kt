package study

class StringPlusCalculator {
    fun calculate(input: String): Int {
        if (input.isBlank()) return 0
        val numbers = ParserForStringPlusCalculator.parse(input)
        return numbers.sum()
    }
}

class ParserForStringPlusCalculator {
    companion object {
        fun parse(input: String): List<Int> {
            if (input.isBlank()) return emptyList()
            val delimiters = "[,:]".toRegex()
            return input.split(delimiters).map { it -> it.toInt() }
        }
    }
}
