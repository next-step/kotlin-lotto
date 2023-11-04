package lotto.controller

import java.lang.IllegalArgumentException

class PurchaseRequest (
    val amount: Int,
) {
    companion object {
        fun from(inputAmount: String): PurchaseRequest {
            val amount = inputAmount.toIntOrNull() ?: throw IllegalArgumentException("구입 금액은 정수여야 합니다")
            return PurchaseRequest(amount)
        }
    }
}
