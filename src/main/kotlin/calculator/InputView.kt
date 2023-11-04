package calculator

fun main() {
    val inputString = readln()
    val inputAnalyzer = InputAnalyzer(inputString)
    inputAnalyzer.validateInput()
    val numbers = inputAnalyzer.extractNumbers()
    val result = NumberCalculator.sum(numbers)
    println(result)
}
