class StringAdditionCalculator {
    fun sum(input: String): Int {
        val (delimiters, expression) = parseDelimitersAndExpression(input)
        val tokens = expression.split(delimiters.toRegex())
        val numbers = tokens.map { it.toIntOrNull() ?: throw IllegalArgumentException("Invalid input: $it") }
        return numbers.sum()
    }

    private fun parseDelimitersAndExpression(input: String): Pair<String, String> {
        return if (input.startsWith("//")) {
            val customDelimiter = input[2]
            val expression = input.substringAfter("\n")
            ",|:|\\$customDelimiter" to expression
        } else {
            ",|:" to input
        }
    }
}
