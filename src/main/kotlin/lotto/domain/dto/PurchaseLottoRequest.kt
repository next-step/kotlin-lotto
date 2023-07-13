package lotto.domain.dto

import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.ManualLottoCount
import lotto.domain.PurchaseAmount

class PurchaseLottoRequest(
    val purchaseAmount: PurchaseAmount,
    val manualLottoCount: ManualLottoCount,
    val manualLottoTickets: LottoTickets,
) {
    init {
        val maxManualLottoCount = purchaseAmount.amount / LottoStore.LOTTO_PRICE
        require(maxManualLottoCount >= manualLottoCount.count) { EXCEEDED_MAXIMUM_AVAILABLE_PURCHASES }
    }

    companion object {
        private const val EXCEEDED_MAXIMUM_AVAILABLE_PURCHASES = "최대 구매 가능 갯수를 넘었습니다."
    }
}
