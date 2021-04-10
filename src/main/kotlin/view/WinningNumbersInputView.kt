package view

object WinningNumbersInputView {
    fun receiveWinningNumbers(): WinningNumbersInput {
        println("\n지난 주 당첨 번호를 입력해주세요")
        val winningNumbers = readLottoNumbers()

        println("보너스 볼을 입력해주세요.")
        val bonus = readBonusNumber(winningNumbers)
        return WinningNumbersInput(winningNumbers, bonus)
    }

    private tailrec fun readLottoNumbers(): ParsedLottoNumbers {
        val input = readLine()!!
        return when (val result = LottoNumberParser.parse(input)) {
            is ParsedLottoNumbers -> return result
            is InvalidLottoNumbers -> {
                println(result.message)
                readLottoNumbers()
            }
        }
    }

    private tailrec fun readBonusNumber(winningNumbers: ParsedLottoNumbers): Int {
        val result = BonusNumberParser.parse(readLine()!!, winningNumbers)

        if (result != null) {
            return result
        }

        println("당첨 번호에 없는 1부터 45 사이의 숫자를 입력해 주세요.")
        return readBonusNumber(winningNumbers)
    }
}
