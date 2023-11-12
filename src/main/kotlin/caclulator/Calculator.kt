package caclulator

object Calculator {

    fun calculate(input: String): Int {
        if (input.startsWith("//")) {
            val split = input.split("\\n")
            val custom = split[0]
            val expr = split[1]
            val operator = custom.split("//")[1]
            return plus(expr, arrayOf(operator))
        }
        return plus(input, arrayOf(",", ":"))
    }

    private fun plus(input: String, operator: Array<String>): Int =
        input.split(delimiters = operator)
            .map { it.toInt() }
            .reduce { acc, i -> acc + i }
}