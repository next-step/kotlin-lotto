package lotto.ui

import lotto.domain.WinningNumbers

object WinningNumberReader {
    fun read(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbersAsCommaSeparatedString = readln()
        val winningNumbers = winningNumbersAsCommaSeparatedString.split(", ").map { it.toInt() }

        return WinningNumbers.of(winningNumbers)
    }
}
