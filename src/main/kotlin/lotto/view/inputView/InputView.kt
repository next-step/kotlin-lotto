package lotto.view.inputView

import lotto.domain.Money
import lotto.domain.WinningLotto

interface InputView {
    fun receiveMoney(): Money
    fun receiveWinningLotto(): WinningLotto
}
