package calculate

fun main() {
    val input = readlnOrNull() ?: ""

    val result = StringAddCalculator.add(input)

    println(result)
}
