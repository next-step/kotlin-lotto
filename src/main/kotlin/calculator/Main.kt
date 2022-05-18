package calculator

fun main() {
    val calculator = StringCalculator()

    println("숫자 문자열을 입력하세요")

    val numberStrings = StringParser.getNumberStrings(readLine())

    println(calculator.sum(numberStrings))
}
