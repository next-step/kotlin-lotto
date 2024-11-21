package stringcalculator

fun main() {
    println("계산할 수식을 입력하세요.")
    val input: String = readln()
    val result = StringCalculator.calculate(input)
    println("계산 결과: $result")
}
