package lotto.domain

class PurchasedLottoTickets(val purchasedCount: Int) {
    val purchasedLottoTickets: List<LottoTicket> = generateLottoTickets()

    init {
        require(purchasedCount >= PURCHASED_COUNT_MIN_VALUE) { INVALID_PURCHASED_COUNT_MESSAGE }
    }

    private fun generateLottoTickets(): List<LottoTicket>  {
        val lottoTickets: MutableList<LottoTicket> = mutableListOf()
        repeat(purchasedCount) { lottoTickets.add(LottoTicket()) }
        return lottoTickets
    }

    companion object {
        const val PURCHASED_COUNT_MIN_VALUE: Int = 1
        const val INVALID_PURCHASED_COUNT_MESSAGE: String = "최소한 로또 1장 이상 구입해야 합니다"
    }
}
