package calculator

fun main() {
    println("사칙연산식을 입력해주세요 ")
    val input = readlnOrNull()
    Calculator.execute(input)
}
