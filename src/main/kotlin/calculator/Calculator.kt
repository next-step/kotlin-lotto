package calculator

fun main() {
    val expression = "//;\n1;2;3"

    val stringAddCalculator = StringAddCalculator.calculate(Expression.created(expression))
    println(stringAddCalculator)
}
