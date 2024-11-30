package lotto.view

class InputView(private val message: String) {
    fun getIntput(): String {
        println(message)
        val input = readlnOrNull()?.trim()
        if (input.isNullOrEmpty()) throw RuntimeException("금액을 입력되지 않았습니다.")
        return input
    }
}
