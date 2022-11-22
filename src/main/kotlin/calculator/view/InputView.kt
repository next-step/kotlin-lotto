package calculator.view

object InputView {
    private const val INPUT_MESSAGE = "계산식을 입력해주세요."

    fun inputFormula(): String {
        println(INPUT_MESSAGE)
        return readln()
    }
}
