package calculator

fun main() {
    val input = readlnOrNull()

    val positiveNumbers = StringSeparator.separate(input)
    val calculate = PlusCalculator(positiveNumbers).calculate()

    println(calculate.value)
}
