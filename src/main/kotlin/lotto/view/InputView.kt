package lotto.view

import lotto.vo.LottoNumber
import lotto.vo.Money

interface InputView {
    fun receiveMoney(): Money

    fun receiveWinningNumbers(): List<LottoNumber>
}
