package calculator.ui

class InputView {
    fun inputString(): String {
        var string = readLine()
        if (string.isNullOrBlank()) string = "0"

        return string.translateEscapes()
    }
}
