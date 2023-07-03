package lotto.domain

import lotto.domain.dto.PurchaseLottoRequest
import lotto.domain.dto.PurchaseLottoResponse

class LottoStore(
    private val lottoGenerator: LottoGenerator
) {
    fun purchaseLottoTickets(purchaseLottoRequest: PurchaseLottoRequest): PurchaseLottoResponse {
        val autoLottoTicketQuantity = getAutoLottoTicketQuantity(
            purchaseLottoRequest.purchaseAmount.amount,
            purchaseLottoRequest.manualLottoCount
        )
        val autoLottoTickets = List(autoLottoTicketQuantity) { lottoGenerator.createLotto() }

        return PurchaseLottoResponse(
            autoLottoTicketQuantity,
            purchaseLottoRequest.manualLottoCount.count,
            purchaseLottoRequest.manualLottoTickets.tickets.plus(autoLottoTickets)
        )
    }

    private fun getAutoLottoTicketQuantity(purchaseAmount: Int, manualLottoCount: ManualLottoCount): Int {
        return (purchaseAmount / LOTTO_PRICE) - manualLottoCount.count
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
