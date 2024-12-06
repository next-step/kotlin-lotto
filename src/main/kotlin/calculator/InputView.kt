package calculator

class InputView {
    fun inputUser(): String {
        println("어떤 계산을 하실까요?")
        return readln()
    }
}
