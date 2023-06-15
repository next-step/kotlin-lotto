package calculator

class Calculator

fun main() {
    val input = "//;\n7;2:1,3"
    val result = StringAddCalculator(input).calculate()
    println("결과 값 : $result")
}