package stringadditioncalculator

fun main() {
    val calculator = StringAdditionCalculator()
    val expression = readln()

    val result = calculator.calculate(expression)
    print(result)
}
