package lotto

data class LottoAmount(val totalAmount: Int, val manualAmount: Int) {
    init {
        require(totalAmount >= manualAmount) { "수동 구매 수는 전체 구매 수 보다 작아야합니다." }
    }

    val autoAmount: Int = totalAmount - manualAmount
}
