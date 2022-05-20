package calculator

fun main() {
    val text = readln()
    val stringAddCalculator = StringAddCalculator()
    val result = stringAddCalculator.calculate(text)
    println(result)
}
