package string.addition.calculator.view

object OutputView {
    private const val RESULT_MESSAGE = "계산 결과: "

    fun printResult(result: Int) {
        println(RESULT_MESSAGE + result)
    }
}
