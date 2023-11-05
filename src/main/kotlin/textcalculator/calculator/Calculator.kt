package textcalculator.calculator

object Calculator {
    fun splitString(input: String, delimiters: List<String> = listOf(",", ":")): List<String> {
        return input.replace(" ", "").split(delimiters)
    }

    private fun String.split(delimiters: List<String>): List<String> {
        return this.split(*delimiters.toTypedArray())
    }

    fun calculate(numbers: List<String>): Int {
        return numbers.sumOf { it.toInt() }
    }
}
