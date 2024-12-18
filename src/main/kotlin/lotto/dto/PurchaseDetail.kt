package lotto.dto

import lotto.domain.LottoTickets
import lotto.domain.LottoTickets.Companion.LOTTO_TICKET_PRICE

data class PurchaseDetail(
    val purchaseAmount: Int,
    val autoLottoQuantity: Int,
    val manualLottoQuantity: Int,
    val manualLottoTickets: LottoTickets,
) {
    init {
        require(manualLottoQuantity * LOTTO_TICKET_PRICE <= purchaseAmount) { "수동으로 구입할 로또의 수량이 구입금액보다 많습니다" }
        require(autoLottoQuantity <= purchaseAmount / LOTTO_TICKET_PRICE) { "자동으로 구입할 로또의 수량이 구입금액보다 많습니다" }
    }
    constructor(
        purchaseAmount: Int,
        manualLottoTickets: LottoTickets,
    ) : this(
        purchaseAmount,
        purchaseAmount / LOTTO_TICKET_PRICE - manualLottoTickets.size,
        manualLottoTickets.size,
        manualLottoTickets,
    )
}
