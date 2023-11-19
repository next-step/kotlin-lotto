package lotto.business

class LottoTicketCounter(val receivedAmount: ReceivedAmount) {
    private var _purchasableCount = receivedAmount.getTicketCount()

    val purchasableCount: Int
        get() = _purchasableCount

    val usedTicketCount: Int
        get() = purchasedCount - purchasableCount

    private val purchasedCount: Int
        get() = receivedAmount.getTicketCount()

    fun decreasePurchasableCount(count: Int) {
        require(_purchasableCount >= count) { throw IllegalArgumentException("더 이상 로또를 구매할 수 없습니다.") }
        _purchasableCount -= count
    }
}
