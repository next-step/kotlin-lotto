package lotto.view

import common.PositiveNumber
import lotto.domain.lottonumber.LottoNumbers

interface LottoInputView {

    fun readLottoPurchaseAmount(): PositiveNumber

    fun readLastWeekWinLottoNumbers(): LottoNumbers
}
