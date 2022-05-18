package stringaddcalculator

object StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        return input.toInt()
    }
}
