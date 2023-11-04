package lotto.view

import lotto.WinningNumbers

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val line = readln()
        return WinningNumbers(line.split(", ").map { it.toInt() })
    }
}
