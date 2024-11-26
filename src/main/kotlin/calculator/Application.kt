package calculator

class Application

fun main() {
    println("덧셈 문자열을 구분자와 함께 입력하세요 (예) 1,2,3,4")
    val inputText = readln()
    val unparsedExpression = UnparsedExpression(inputText)
    val result = AdditionCalculator.calculate(unparsedExpression)
    println("덧셈 결과 : $result")
}
