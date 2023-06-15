package lotto.view.output

abstract class OutputView(private val message: String) {
    fun renderMessage() {
        println(message)
    }
}
