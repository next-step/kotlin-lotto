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

            if (input.startsWith("//")) {
                val customDelimiter = input.substring(2, 3)
                val numbers = input.substring(4).split(customDelimiter)
                return numbers.map { it.toInt() }
            }
            val delimiters = "[,:]".toRegex()
            val numbers = input.split(delimiters)
            return numbers.map { it.toInt() }
        }
    }
}
