package string.addition.calculator.view

object InputView {
    private const val ENTER_INPUT_MESSAGE = "계산할 문자열을 입력하세요."

    fun receiveCalculatorInput(): String? {
        println(ENTER_INPUT_MESSAGE)
        return readlnOrNull()
    }
}
