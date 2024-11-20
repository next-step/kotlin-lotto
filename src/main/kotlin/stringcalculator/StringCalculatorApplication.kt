package stringcalculator

fun main() {
    println("계산할 수식을 입력하세요.")
    val input: String = readln()
    val result = StringCalculator(input).calculate()
    println("계산 결과: $result")
}
