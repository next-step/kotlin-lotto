package lotto.presentation.controller.dto

class PurchaseRequest private constructor(
    val amount: Int,
) {
    companion object {
        fun from(inputAmount: Int): PurchaseRequest {
            return PurchaseRequest(inputAmount)
        }
    }
}
