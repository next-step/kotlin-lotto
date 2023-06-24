package lotto.view

import lotto.ManualPurchaseCommand
import lotto.vo.Money
import lotto.vo.WinningNumbers

interface InputView {
    fun receiveMoney(): Money
    fun receiveWinningNumbers(): WinningNumbers
    fun receivePurchaseCommand(): ManualPurchaseCommand
}
