package lotto.ui

import lotto.domain.WinningNumbers

object InputUI {

    fun receivePurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return requireNotNull(readLine()).toInt()
    }

    fun receiveWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = requireNotNull(readLine())
        return WinningNumbers.fromCSV(input)
    }
}
