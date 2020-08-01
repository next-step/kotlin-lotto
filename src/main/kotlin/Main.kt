import calculator.Calculator

fun main() {
    try {
        println("계산하기 위한 문자열을 입력해주세요.")
        val calculator = Calculator(readLine()!!)
        val result = calculator.execute()
        println("총합은 $result 입니다.")
    } catch (e: Exception) {
        println(e.message)
    }
}
