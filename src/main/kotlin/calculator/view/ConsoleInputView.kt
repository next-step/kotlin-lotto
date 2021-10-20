package calculator.view

class ConsoleInputView : InputView {
    override fun receiveInputExpression(): String? {
        println("계산할 수식을 입력하세요.(x키는 종료)")
        return readLine()
    }
}
