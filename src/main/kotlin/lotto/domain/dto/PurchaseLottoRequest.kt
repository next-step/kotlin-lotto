package lotto.domain.dto

import lotto.domain.LottoStore
import lotto.domain.LottoTickets
import lotto.domain.ManualLottoCount
import lotto.domain.PurchaseAmount
import lotto.view.ExceptionMessage

class PurchaseLottoRequest(
    val purchaseAmount: PurchaseAmount,
    val manualLottoCount: ManualLottoCount,
    val manualLottoTickets: LottoTickets,
) {
    init {
        val maxManualLottoCount = purchaseAmount.amount / LottoStore.LOTTO_PRICE
        require(maxManualLottoCount >= manualLottoCount.count) { ExceptionMessage.EXCEEDED_MAXIMUM_AVAILABLE_PURCHASES.message }
    }
}
