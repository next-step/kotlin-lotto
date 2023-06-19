package lotto.view

import lotto.domain.lottonumber.LottoNumbers
import math.PositiveNumber

interface LottoInputView {

    fun readLottoPurchaseAmount(): PositiveNumber

    fun readLastWeekWinLottoNumbers(): LottoNumbers
}
