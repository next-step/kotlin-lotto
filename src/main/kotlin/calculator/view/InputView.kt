package calculator.view

object InputView {
    private const val INPUT_EXPRESSION = "계산할 식을 입력해주세요!"

    fun readExpression(): String? {
        println(INPUT_EXPRESSION)
        return readLine()
    }
}
