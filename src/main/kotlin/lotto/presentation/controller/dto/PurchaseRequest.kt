package lotto.presentation.controller.dto

import lotto.domain.LottoStore.Companion.LOTTO_PRICE

class PurchaseRequest private constructor(
    val amount: Int,
) {
    companion object {
        fun from(inputAmount: Int): PurchaseRequest {
            return PurchaseRequest(inputAmount)
        }
    }
}
