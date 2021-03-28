package view

object WinningNumbersInputView {
    fun receiveWinningNumbers(): WinningNumbersInput {
        println("\n지난 주 당첨 번호를 입력해주세요")
        return WinningNumbersInput(readLine()!!)
    }
}
