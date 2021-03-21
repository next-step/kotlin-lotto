package view

class WinningNumbersInputView {
    fun receiveWinningNumbers(sentence: String): WinningNumbersInput {
        println("\n$sentence")
        return WinningNumbersInput(readLine()!!)
    }
}
