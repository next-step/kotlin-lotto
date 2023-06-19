package lotto.view

import lotto.domain.lottonumber.WinLottoNumbers
import math.PositiveNumber

interface LottoInputView {

    fun readLottoPurchaseAmount(): PositiveNumber

    fun readLastWeekWinLottoNumbers(): WinLottoNumbers
}
