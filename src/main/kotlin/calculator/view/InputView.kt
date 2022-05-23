package calculator.view

class InputView {

    fun inputText(): String {
        println("덧셈을 진행할 문자열을 입력해주세요.")
        return readln()
    }
}
