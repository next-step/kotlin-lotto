package lotto.view.input

import lotto.domain.LottoPurchaseAmount
import lotto.domain.WinningInfo

interface InputView {
    fun getPurchaseAmount(): LottoPurchaseAmount
    fun getWonNumbers(): WinningInfo
}
