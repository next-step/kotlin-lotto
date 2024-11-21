package calculator

fun main(args: Array<String>) {
    val str = readln()
    val calculator = StringAdditionCalculator(str)
    println(calculator.add())
}
