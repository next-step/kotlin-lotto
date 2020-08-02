package calculator.view

object ResultView {
    private const val RESULT = "실행 결과"
    private const val ERR_INVALID_EXPRESSION = "유효한 식이 아닙니다."

    fun printResult(result: Int) {
        println("$RESULT : $result")
    }

    fun printErr() {
        println(ERR_INVALID_EXPRESSION)
    }
}
