package lotto.model

data class LottoStore(
    private val mainLottoTicketStorage: LottoTicketStorage,
    private val subLottoTicketStorage: LottoTicketStorage,
    private val price: Long,
) {

    init {
        require(MIN_PRICE <= price) { "price must be greater than $MIN_PRICE. but provided price(`$price`)" }
    }

    fun purchaseLottoTicketsBy(mainBuyCount: Int, money: Long): PurchasedLottoTickets {
        val availableBuyCount: Int = (money / price).toInt()
        validateBuyCount(availableBuyCount, mainBuyCount)

        return PurchasedLottoTickets(
            tickets = lottoTickets(mainLottoTicketStorage, mainBuyCount) +
                lottoTickets(subLottoTicketStorage, availableBuyCount - mainBuyCount),
            pricePerTicket = price
        )
    }

    private fun lottoTickets(storage: LottoTicketStorage, buyCount: Int): Collection<LottoTicket> {
        validateStorageRemainCount(storage, buyCount)
        return storage lottoTicketsBy buyCount
    }

    private fun validateBuyCount(availableBuyCount: Int, buyCount: Int) {
        if (availableBuyCount < buyCount) {
            throw IllegalArgumentException(
                "buyCount must be greater than or equal to primaryBuyCount. " +
                    "availableBuyCount(`$availableBuyCount`), buyCount(`$buyCount`)"
            )
        }
    }

    private fun validateStorageRemainCount(storage: LottoTicketStorage, primaryBuyCount: Int) {
        if (storage hasCountLessThan primaryBuyCount) {
            throw IllegalStateException(
                "primaryStorage has less than butCount. " +
                    "primaryStorage($storage), primaryBuyCount(`$primaryBuyCount`)"
            )
        }
    }

    companion object {
        private const val MIN_PRICE = 1
    }
}
