package lotto.view.output

abstract class OutputView(var message: String = "") {
    fun renderMessage() {
        println(message)
    }
}
