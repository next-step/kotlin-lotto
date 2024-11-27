package stringcalculator.core

object Calculator {
    fun sum(numbers: List<Number>): Int {
        val sum = numbers.reduce(Number::plus)
        return sum.number
    }
}
