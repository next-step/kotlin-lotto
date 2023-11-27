package caclulator

object Calculator {

    fun calculate(input: String?): Int {
        val parsed = Parser.parse(input)
        if (parsed.isEmpty()) {
            return 0
        }
        return parsed.reduce { acc, i -> acc + i }
    }
}
