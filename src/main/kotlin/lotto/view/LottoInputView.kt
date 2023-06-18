package lotto.view

import common.PositiveNumber

interface LottoInputView {

    fun readLottoPurchaseAmount(): PositiveNumber
}
