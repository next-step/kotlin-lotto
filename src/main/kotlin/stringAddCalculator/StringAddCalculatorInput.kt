package stringAddCalculator

class StringAddCalculatorInput(private val input: String) {
    fun parse(): List<Int> {
        if (input.isEmpty()) {
            return listOf()
        }

        return input.split(",").map { it.toInt() }
    }
}
