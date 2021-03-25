package lotto.store

data class PurchaseRequest(val amount: Long, val txManualLottoTickets: List<String>) {
    companion object {
        fun ofTxAmount(txAmount: String, txManualLottoTickets: List<String>): PurchaseRequest {
            return PurchaseRequest(txAmount.toLong(), txManualLottoTickets)
        }
    }
}
