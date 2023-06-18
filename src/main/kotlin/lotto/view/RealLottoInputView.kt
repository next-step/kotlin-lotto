package lotto.view

import common.PositiveNumber

class RealLottoInputView : LottoInputView {

    override fun readLottoPurchaseAmount(): PositiveNumber {
        println("구입금액을 입력해 주세요.")
        return PositiveNumber(readln().toInt())
    }
}
