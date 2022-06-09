package lotto.domain

object LottoStore {
    const val LOTTO_TICKET_PRICE = 1000

    fun buyAutoLottoTicket(purchaseAmount: Int, manualLottoCount: Int): LottoTickets {
        validatePurchaseAmount(purchaseAmount)

        val numberOfTicket = getTotalBuyCount(purchaseAmount) - manualLottoCount
        return LottoTicketMachine.generate(numberOfTicket)
    }

    fun checkBuyAutoLotto(purchaseAmount: Int, manualLottoCount: Int) {
        validatePurchaseAmount(purchaseAmount)

        require(getTotalBuyCount(purchaseAmount) >= manualLottoCount) {
            "수동 구매 횟수를 초과하였습니다."
        }
    }

    private fun validatePurchaseAmount(purchaseAmount: Int) {
        require(purchaseAmount > LOTTO_TICKET_PRICE) {
            "금액이 부족합니다."
        }
    }

    private fun getTotalBuyCount(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_TICKET_PRICE
    }
}
