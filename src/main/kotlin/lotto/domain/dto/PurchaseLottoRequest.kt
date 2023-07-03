package lotto.domain.dto

import lotto.domain.LottoStore
import lotto.domain.ManualLottoCount
import lotto.domain.PurchaseAmount

class PurchaseLottoRequest(
    purchaseAmount: PurchaseAmount,
    manualLottoCount: ManualLottoCount,
) {
    private val maxManualLottoCount = purchaseAmount.amount / LottoStore.LOTTO_PRICE

    init {
        require(maxManualLottoCount >= manualLottoCount.count) { println("최대 ${maxManualLottoCount}장 구매 가능합니다.") }
    }
}
