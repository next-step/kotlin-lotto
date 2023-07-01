package lotto.sixFortyFiveNumberLotto

import lotto.ErrorCode

class SixFortyFiveLottoCount(val value: Int) {
    init {
        require(value >= 0) { ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_COUNT.msg }
    }
}
