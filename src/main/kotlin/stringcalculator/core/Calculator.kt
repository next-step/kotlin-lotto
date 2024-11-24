package stringcalculator.core

object Calculator {
    fun sum(numbers: List<Number>): Int {
        val sum = numbers.reduce { number1, number2 -> number1 + number2 }

        return sum.number
    }
}
