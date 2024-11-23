package stringcalculator.core

object Calculator {
    fun sum(numbers: List<Number>): Int {
        if (numbers.isEmpty()) {
            return 0
        }

        return numbers.sumOf { it.number }
    }
}
