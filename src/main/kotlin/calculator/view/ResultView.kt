package calculator.view

object ResultView {
    private const val RESULT_MESSAGE = "계산결과 :"

    fun printResult(result: Int) {
        println("$RESULT_MESSAGE $result")
    }
}
