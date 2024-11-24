package string_calculator

class InputView(private val requestMessage: String) {
    fun getInputMessage(): String {
        println(requestMessage)
        return readlnOrNull()?.trim() ?: ""
    }
}