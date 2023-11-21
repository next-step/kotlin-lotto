package lotto.presentation.controller.dto

import lotto.domain.LottoStore.Companion.LOTTO_PRICE

class PurchaseRequest private constructor(
    val amount: Int,
) {
    companion object {
        fun from(inputAmount: String): PurchaseRequest {
            val amount = inputAmount.toIntOrNull() ?: throw IllegalArgumentException("구입 금액은 정수여야 합니다")
            require(amount % LOTTO_PRICE == 0) { "구입 금액은 로또 가격의 배수여야 합니다." }
            return PurchaseRequest(amount)
        }
    }
}
