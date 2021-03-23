package view

object WinningNumbersInputView {
    fun receiveWinningNumbers(sentence: String): WinningNumbersInput {
        printDirectiveSentence(sentence)
        return WinningNumbersInput(readLine()!!)
    }

    private fun printDirectiveSentence(sentence: String) {
        println("\n$sentence")
    }
}
