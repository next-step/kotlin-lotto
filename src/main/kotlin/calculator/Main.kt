package calculator

fun main() {
    val numbers = Splitter.getNumbers("//;\n1;2;3")

    val calculator = Calculator(numbers.map { CalculatorNumber(it).num })

    calculator.calculate()

    println(calculator.sum)
}
