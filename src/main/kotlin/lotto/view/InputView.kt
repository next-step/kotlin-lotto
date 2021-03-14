package lotto.view

object InputView {
    fun readLine(message: String): String {
        var input: String? = null
        while (input.isNullOrBlank()) {
            println(message)
            input = readLine()
        }

        return input
    }
}
