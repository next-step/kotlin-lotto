package calculator

fun main() {
    try {
        println("덧셈식을 입력해주세요. 구분자는 ,와:을 사용합니다(단 음수는 계산할수없습니다.)")
        val inputValue = readLine()
        val calculator = StringAddCalculator(inputValue)
        val result = calculator.sum()
        println(result)
    } catch (e: RuntimeException) {
        println(e.message)
    }
}
