package lotto.view.inputView

import lotto.domain.LottoNumber
import lotto.domain.money.Money

interface InputView {
    fun receiveMoney(): Money
    fun receiveWinningNumbers(): List<LottoNumber>
}
