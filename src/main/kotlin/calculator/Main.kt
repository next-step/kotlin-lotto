package calculator

class Main

fun main() {

    // 0. 사용자에게 문자열을 입력받는다.
    print("문자열을 입력하세요 : ")
    val text: String? = readlnOrNull()

    // 1. 입력받은 문자열을 계산한다.
    val calculator = StringAddCalculator()
    val result = calculator.add(text)

    // 2. 계산 결과를 출력한다.
    println("result = $result")
}
