package lotto.view

class InputView<T>(
    private val inputMessage: String
) {
    fun receiveUserInput() {
        printInputMessage()
    }

    private fun printInputMessage() {
        println(inputMessage)
    }
}
