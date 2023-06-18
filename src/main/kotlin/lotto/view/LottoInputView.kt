package lotto.view

import math.PositiveNumber
import lotto.domain.lottonumber.LottoNumbers

interface LottoInputView {

    fun readLottoPurchaseAmount(): PositiveNumber

    fun readLastWeekWinLottoNumbers(): LottoNumbers
}
