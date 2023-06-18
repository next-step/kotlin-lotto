package lotto.view

import lotto.vo.Money

interface InputView {
    fun receiveMoney(): Money

    fun receiveWinningNumbers(): List<Int>
}
