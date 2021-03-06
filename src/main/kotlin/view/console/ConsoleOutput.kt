package view.console

class ConsoleOutput {
    fun printStringAdderInputMessage() {
        println("덧셈할 숫자를 쉼표(,)와 콜론(:)으로 구분해서 입력해주세요.")
    }

    fun printStringAdderResultMessage(result: Int) {
        println("결과는 ${result}입니다.")
    }
}