package lotto.domain

import lotto.error.ErrorMessage.MIN_LOTTO_COUNT

class LottoPurchaseInfo(val autoLottoCount: Int, val manualLottoCount: Int) {
    init {
        require(autoLottoCount > 0 || manualLottoCount > 0) { MIN_LOTTO_COUNT.message }
    }
}
