package calculator

object StringAdditionCalculator {
    private val delimiters = listOf(',', ':')

    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        return addNumbers(input)
    }

    private fun addNumbers(input: String): Int =
        input
            .split(*delimiters.toCharArray())
            .sumOf { parseNumber(it) }

    private fun parseNumber(input: String): Int {
        val number = input.toIntOrNull() ?: throw RuntimeException("input should contain only numbers but has $input")
        if (number < 0) throw RuntimeException("Number should not be negative but was $number")
        return number
    }
}
