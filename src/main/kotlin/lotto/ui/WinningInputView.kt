package lotto.ui

import lotto.data.LottoNumber
import lotto.data.LottoNumbers
import lotto.data.WinningNumbers

object WinningInputView {
    fun askWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = askWinningSixNumber()
        val bonusNumber = askWinningBonusNumber()
        return WinningNumbers(numbers, bonusNumber)
    }

    private fun askWinningSixNumber(): List<Int> {
        val numbersString = readLine() ?: throw IllegalArgumentException("입력 값이 존재하지 않습니다.")
        return splitWinningNumbers(numbersString)
    }

    private fun askWinningBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값입니다.")
    }

    private fun splitWinningNumbers(numbersString: String): List<Int> =
        numbersString.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값이 있습니다. ($it)") }
}
