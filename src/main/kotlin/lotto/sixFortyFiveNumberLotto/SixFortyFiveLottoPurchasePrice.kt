package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveLottoPurchasePrice(val value: Int) {
    init {
        require(value >= SixFortyFiveLotto.LOTTO_PRICE) { ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_PURCHASE_PRICE.msg }
    }
}
