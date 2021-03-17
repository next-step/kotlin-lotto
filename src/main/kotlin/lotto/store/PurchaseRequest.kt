package lotto.store

data class PurchaseRequest(val amount: Long) {
    companion object {
        fun ofTxAmount(txAmount: String): PurchaseRequest {
            return PurchaseRequest(txAmount.toLong())
        }
    }
}
