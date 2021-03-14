package calculator

fun main() {
    print("입력해 주세요 : ")
    val expression = readLine()!!

    val stringAddCalculator = StringAddCalculator()
    val result = stringAddCalculator.add(expression)
    print("결과는 : $result 입니다")
}
