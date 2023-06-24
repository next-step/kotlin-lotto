package lotto.view

import lotto.LottoPurchaseRequest
import lotto.vo.Money
import lotto.vo.WinningNumbers

interface InputView {
    fun receiveMoney(): Money
    fun receiveWinningNumbers(): WinningNumbers
    fun receivePurchaseCommand(): LottoPurchaseRequest
}
