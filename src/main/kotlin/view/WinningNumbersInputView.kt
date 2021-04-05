package view

object WinningNumbersInputView {
    fun receiveWinningNumbers(): WinningNumbersInput {
        println("\n지난 주 당첨 번호를 입력해주세요")
        val winningNumbers = readLottoNumbers()

        println("보너스 볼을 입력해주세요.")
        val bonus = readLine()!!.toInt()
        return WinningNumbersInput(winningNumbers, bonus)
    }

    private tailrec fun readLottoNumbers(): ParsedManualNumbers {
        val input = readLine()!!
        return when (val result = LottoNumberParser.parse(input)) {
            is ParsedManualNumbers -> return result
            is InvalidManualNumbers -> {
                println(result.message)
                readLottoNumbers()
            }
        }
    }
}
