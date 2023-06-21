package lotto.view

import lotto.domain.lottonumber.WinLottoNumbers
import lotto.domain.shop.LottoPurchasePaper

interface LottoInputView {

    fun readLottoPurchaseInfo(): LottoPurchasePaper

    fun readLastWeekWinLottoNumbers(): WinLottoNumbers
}
