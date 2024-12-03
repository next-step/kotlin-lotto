package lotto.core

import lotto.core.constant.LottoConstants

class LottoPurchaseCount(private val totalLottoCount: Int, val manualLottoCount: Int) {
    init {
        require(totalLottoCount >= 0 && manualLottoCount >= 0) { LottoConstants.ERROR_NOT_INVALID_LOTTO_COUNT }
        require(totalLottoCount >= manualLottoCount) { LottoConstants.ERROR_NOT_INVALID_LOTTO_COUNT }
    }

    fun autoLottoCount(): Int {
        return totalLottoCount - manualLottoCount
    }
}
