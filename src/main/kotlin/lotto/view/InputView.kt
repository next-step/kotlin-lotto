package lotto.view

import lotto.vo.Money
import lotto.vo.WinningNumbers

interface InputView {
    fun receiveMoney(): Money

    fun receiveWinningNumbers(): WinningNumbers
}
