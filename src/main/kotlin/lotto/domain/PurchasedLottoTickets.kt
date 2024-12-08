package lotto.domain

data class PurchasedLottoTickets(val purchasedCount: Int, private val generateLottoNumbers: () -> Set<Int>) {
    val purchasedLottoTickets: List<LottoTicket>

    init {
        require(purchasedCount >= PURCHASED_COUNT_MIN_VALUE) { INVALID_PURCHASED_COUNT_MESSAGE }
        purchasedLottoTickets =
            List(purchasedCount) {
                LottoTicket(generateLottoNumbers = generateLottoNumbers)
            }
    }

    companion object {
        const val PURCHASED_COUNT_MIN_VALUE: Int = 1
        const val INVALID_PURCHASED_COUNT_MESSAGE: String = "최소한 로또 1장 이상 구입해야 합니다"
    }
}
