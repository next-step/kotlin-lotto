package calculator

fun main() {
    println("계산할 문자열을 입력하세요.")
    val input = readln()
    val stringAddCalculator = StringAddCalculator(input)
    println(stringAddCalculator.add())
}
