package lotto.view

class InputView {
    fun printMsgAndReadValue(message: String): String? {
        println(message)
        return readlnOrNull()
    }
}
