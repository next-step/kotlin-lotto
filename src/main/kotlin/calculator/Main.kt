package calculator

class Main

fun main() {

    print("문자열을 입력하세요 : ")
    val text: String? = readlnOrNull()

    val calculator = StringAddCalculator()
    val result = calculator.add(text)

    println("result = $result")
}
