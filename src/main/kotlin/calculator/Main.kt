package calculator

fun main() {
    val stringAddCalculator = StringAddCalculator()

    val text = readln()
    val result = stringAddCalculator.add(text)
    println(result)
}
