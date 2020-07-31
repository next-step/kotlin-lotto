package calculator

fun main() {
    println("덧셈 식을 입력해주세요. ,와:으로 구분합니다. (단 음수는 입력할수없습니다)")
    val inputValue = readLine()
    val calculator = StringAddCalculator(inputValue)
    val result = calculator.plus()
    println(result)
}
