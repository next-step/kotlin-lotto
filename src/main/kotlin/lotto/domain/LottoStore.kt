package lotto.domain

object LottoStore {
    const val LOTTO_TICKET_PRICE = 1000

    fun buyAutoLottoTicket(purchaseAmount: Int, manualLottoCount: Int): LottoTickets {
        isEnoughMoney(purchaseAmount)

        val numberOfTicket = getTotalBuyCount(purchaseAmount) - manualLottoCount
        return LottoTicketMachine.generate(numberOfTicket)
    }

    fun isBuyAutoLotto(purchaseAmount: Int, manualLottoCount: Int) {
        isEnoughMoney(purchaseAmount)

        require(getTotalBuyCount(purchaseAmount) >= manualLottoCount) {
            "수동 구매 횟수를 초과하였습니다."
        }
    }

    private fun isEnoughMoney(purchaseAmount: Int) {
        require(purchaseAmount > LOTTO_TICKET_PRICE) {
            "금액이 부족합니다."
        }
    }

    private fun getTotalBuyCount(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_TICKET_PRICE
    }
}
