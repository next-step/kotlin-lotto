package calculator

class StringAddCalculator(
    val input: String
) {
    fun separateStrings(): List<Int> {
        return input.split(",", ":").map { it.toInt() }
    }
}
