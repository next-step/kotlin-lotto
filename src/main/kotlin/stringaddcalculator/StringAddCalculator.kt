package stringaddcalculator

object StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        val numbers = input.split(",", ":").map { it.toInt() }
        return numbers.sum()
    }
}
