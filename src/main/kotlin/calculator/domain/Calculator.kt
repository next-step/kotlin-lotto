package calculator.domain

class Calculator {
    fun sum(numbers: List<Number>) = numbers.sumBy { it.number }
}
