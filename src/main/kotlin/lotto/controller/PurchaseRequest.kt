package lotto.controller

class PurchaseRequest(
    val amount: Int,
) {
    companion object {
        fun from(amount: Int): PurchaseRequest {
            return PurchaseRequest(amount)
        }
    }
}
