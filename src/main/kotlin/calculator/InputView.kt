package calculator

private const val INPUT_TEXT = "구분자와 함께 덧셈할 숫자를 입력하세요"

object InputView {
    fun getInput(): String {
        println(INPUT_TEXT)
        return readln()
    }
}