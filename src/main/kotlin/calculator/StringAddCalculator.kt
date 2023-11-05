package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val numbers = text.split(",")

        return numbers.sumOf { it.toInt() }
    }
}